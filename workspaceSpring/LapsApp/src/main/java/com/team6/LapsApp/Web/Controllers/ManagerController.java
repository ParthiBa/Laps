package com.team6.LapsApp.Web.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
