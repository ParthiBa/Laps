package com.team6.LapsApp.Web.Controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.team6.LapsApp.model.*;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private LeaveApplicationService m_Service;
		
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
	}
	
	@RequestMapping(value = "/employeeForm", method = RequestMethod.GET)
    public String InitEmployeeForm(Map<String, Object> model) {
        Employee e = new Employee();
        e.setEmployeeID("E01");
        model.put("employeelogedin", e);
        return "EmployeeOptions";
    }

	@RequestMapping(value = "/newLeave", method = RequestMethod.GET)
    public String initLeaveCreationForm(@Param ("EmployeeID") String empid,Map<String, Object> model) {
        LeaveDetail ld = new LeaveDetail();
        Employee e = new Employee();
        e.setEmployeeID("E01");
        model.put("employeelogedin", e);
        model.put("leave", ld);
        return "LeaveApplication";
    }

    @RequestMapping(value = "{EmployeeID}/newLeave", method = RequestMethod.POST)
    public String processLeaveCreationForm(@Param ("EmployeeID") String EmployeeID,@Valid LeaveDetail ld, BindingResult result, SessionStatus status) {
    	Manager m = this.m_Service.findManagerByID(ld.getM_manager().getEmployeeID());
		m.addleavestoApprove(ld);
		Employee e = this.m_Service.findById("E01");
		e.addPersonalLeaves(ld);
	    this.m_Service.ApplyLeave(ld);
	    status.setComplete();
	    return "redirect:/employee/GetmaxleavePerson/E01";
    }

    @RequestMapping(value = "/GetmaxleavePerson/{empid}", method = RequestMethod.GET)
	public ModelAndView GetPersonalLeaveHIstory(@Param ("empid") String empid) {
		ModelAndView mav = new ModelAndView("EmployeeOptions");
		List<LeaveDetail> List = m_Service.FindPersonalLeaves(empid);
		mav.addObject("PersonalLeaves", List);
		return mav;
	}
}
