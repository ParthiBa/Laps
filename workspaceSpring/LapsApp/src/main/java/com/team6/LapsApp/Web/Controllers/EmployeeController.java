package com.team6.LapsApp.Web.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.service.EmployeeService;
import com.team6.LapsApp.service.LeaveDetailsService;



@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private LeaveDetailsService m_LdService;
	@Autowired
	private EmployeeService m_empService;
	

	
	@RequestMapping(value = "/InitFindEmployee", method = RequestMethod.GET)
	public String InitFindEmployee(Map<String, Object> model) {
		model.put("employee", new Employee());
        return "EmployeeOptions";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public ModelAndView ProcessFindEmployee(Employee emp, BindingResult result, Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		List<LeaveDetail> List = m_LdService.FinfPersonalLeaveHistroy(emp.getEmployeeID());
		mav.addObject("LeaveDetailList", List);
		return mav;
	}
	
	@RequestMapping(value = "/Alllistleavedetails", method = RequestMethod.GET)
	public ModelAndView EmployeeLeaveListAllPage() {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		List<LeaveDetail> List = m_LdService.FindAllLeave();
		mav.addObject("LeaveList", List);
		return mav;
	}

	@RequestMapping(value = "/listleavedetails/{empID}", method = RequestMethod.GET)
	public ModelAndView EmployeeLeaveListPage(@PathVariable String empID) {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		List<LeaveDetail> List = m_LdService.FinfPersonalLeaveHistroy(empID);
		mav.addObject("LeaveDetailList", List);
		return mav;
	}
	
	@RequestMapping(value = "/listmaxleave", method = RequestMethod.GET)
	public ModelAndView ListMaxLeavePage() {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		/*List<LeaveDetail> List = m_LdService.ListMaxLeavesList();
		mav.addObject("LeaveDetailList", List);*/
		return mav;
	}
	
	@RequestMapping(value = "/GetmaxleavePerson", method = RequestMethod.GET)
	public ModelAndView GetmaxleavePerson() {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		List<LeaveDetail> List = m_LdService.ListPersonTookMaxLeave();
		String empid = List.get(0).getEmployeeID();
		Employee emp = m_empService.findById(empid);
		mav.addObject("Employee", emp);
		return mav;
	}
}
