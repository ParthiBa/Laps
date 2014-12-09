package com.team6.LapsApp.Web.Controllers;

import java.util.Map;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private LeaveApplicationService m_Service;
	
	private Employee loggedinemp;
		
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
	}
	
	/*@RequestMapping(value = "/employeeForm", method = RequestMethod.GET)
    public String InitEmployeeForm(Map<String, Object> model) {
        Employee e = new Employee();
        e.setEmployeeID("E01");
        model.put("employeelogedin", e);
        return "EmployeeOptions";
    }*/

	@RequestMapping(value = "/newLeave", method = RequestMethod.GET)
    public String initLeaveCreationForm(@Param ("EmployeeID") String empid,Map<String, Object> model) {
        LeaveDetail ld = new LeaveDetail();
        Employee e = new Employee();
        e.setEmployeeID("E01");
        model.put("employeelogedin", e);
        model.put("leave", ld);
        return "ApplyLeave";
    }

    @RequestMapping(value = "{EmployeeID}/newLeave", method = RequestMethod.POST)
    public String processLeaveCreationForm(@Param ("EmployeeID") String EmployeeID,@Valid LeaveDetail ld, BindingResult result, SessionStatus status) {
    	Manager m = this.m_Service.findManagerByID(ld.getM_manager().getEmployeeID());
		m.addleavestoApprove(ld);
		Employee e = this.m_Service.findEmployee("E01");
		e.addPersonalLeaves(ld);
		ld.setM_empbase(e);
	    this.m_Service.ApplyLeave(ld);
	    status.setComplete();
	    return "redirect:/employee/GetmaxleavePerson/E01";
    }
    
    @RequestMapping(value = "/newClaim", method = RequestMethod.GET)
    public String initClaimCreationForm(@Param ("EmployeeID") String empid,Map<String, Object> model) {
        OTDetail ot = new OTDetail();
        Employee e = new Employee();
        e.setEmployeeID("E01");
        model.put("employeelogedin", e);
        model.put("claim", ot);
        return "ClaimApplication";
    }

    @RequestMapping(value = "{EmployeeID}/newClaim", method = RequestMethod.POST)
    public String processClaimCreationForm(@Param ("EmployeeID") String EmployeeID,@Valid OTDetail ot, BindingResult result, SessionStatus status) {
    	Manager m = this.m_Service.findManagerByID(ot.getM_manager().getEmployeeID());
		m.addClaimtoApprove(ot);
		Employee e = this.m_Service.findEmployee("E01");
		e.addPersonalclaims(ot);
		ot.setM_empot(e);
	    this.m_Service.ApplyClaim(ot);
	    status.setComplete();
	    return "EmployeeOptions";
    }

    @RequestMapping(value = "/GetPersonalLeaveHIstory/{empid}", method = RequestMethod.GET)
	public String GetPersonalLeaveHIstory(@Param ("empid") String empid,
													Map<String, Object> model) {
        Employee e = new Employee();
        e.setEmployeeID("E01");
        model.put("employeelogedin", e);
		return "PersonalLeaves";
	}
}
