package com.team6.LapsApp.Web.Controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveDetailCompositeID;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
	
	@Autowired
	private LeaveApplicationService m_Service;
	
	@Autowired
    public ManagerController(LeaveApplicationService Service) {
        this.m_Service = Service;
    }
	
	@RequestMapping(value = "/InitManagerWindow", method = RequestMethod.GET)
	public String InitManagerWindow(Map<String, Object> model) {
        return "ManagerHomePage";
	}
	
	@RequestMapping(value = "/InitManagerLeaveApproveWindow", method = RequestMethod.GET)
	public String InitManagerLeaveApproveWindow(Map<String, Object> model) {
		Manager manager = new Manager();
		manager.setEmployeeID("M01");//Take this detail from login screen later
		manager = (Manager) m_Service.findManagerByID("M01");
	    model.put("manager", manager);
        return "Manager/LeaveToApprove";
	}
	
	@RequestMapping(value = "/InitManagerClaimApproveWindow", method = RequestMethod.GET)
	public String InitManagerClaimApproveWindow(Map<String, Object> model) {
		Manager manager = new Manager();
		manager.setEmployeeID("M01");//Take this detail from login screen later
		manager = (Manager) m_Service.findManagerByID("M01");
	    model.put("manager", manager);
        return "Manager/ClaimToApprove";
	}

	@RequestMapping(value = "/approveorreject", method = RequestMethod.POST)
	public String approveorreject(@RequestParam String Approved,
			@RequestParam String Rejected
			,@RequestParam String empid
			,@RequestParam Date date) {
		LeaveDetailCompositeID ldkey = new LeaveDetailCompositeID(empid,date);
		LeaveDetail ld = m_Service.GetLeaveById(ldkey);
		if(Approved.equals("Approve"))
			ld.setLeaveStatus("Approved");
		else
			ld.setLeaveStatus("Rejected");
		
		m_Service.LeaveDetailsUpdate(ld);
		return "redirect:/manager/InitManagerClaimApproveWindow";
    }
}
