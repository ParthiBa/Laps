package com.team6.LapsApp.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team6.LapsApp.model.*;
import com.team6.LapsApp.service.EmployeeService;
import com.team6.LapsApp.service.LeaveDetailsService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private LeaveDetailsService m_LdService;
	@Autowired
	private EmployeeService m_empService;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
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
		List<LeaveDetail> List = m_LdService.ListMaxLeavesList();
		mav.addObject("LeaveDetailList", List);
		return mav;
	}
	
	@RequestMapping(value = "/GetmaxleavePerson", method = RequestMethod.GET)
	public ModelAndView GetmaxleavePerson() {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		List<LeaveDetail> List = m_LdService.ListMaxLeavesList();
		ListMaxLeavePage();
		m_empService
		String empid = List.get(0).getEmployeeID();
		
		mav.addObject("LeaveDetailList", List);
		return mav;
	}
}
