package com.team6.LapsApp.Web.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
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
		manager.setEmployeeID("JN");//Take this detail from login screen later
		manager = (Manager) m_Service.findManagerByID("M01");
	    model.put("manager", manager);
        return "Manager/LeaveToApprove";
	}
	
	@RequestMapping(value = "/InitManagerClaimApproveWindow", method = RequestMethod.GET)
	public String InitManagerClaimApproveWindow(Map<String, Object> model) {
		Manager m = (Manager)model.get("manager");
        return "Manager/ClaimToApprove";
	}
		
	/*@RequestMapping(value = "/findLeaveToApprove", method = RequestMethod.POST)
	public ModelAndView processLeaveApproveWindow(BindingResult result, Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("Manager/LeaveToApprove");
		Manager m = (Manager)model.get("manager");
		List<LeaveDetail> List = m_Service.FindLeaveApplicationForApproval(m.getEmployeeID());
		mav.addObject("LeaveListForApproval", List);
		return mav;
	}
		
	@RequestMapping(value = "/findClaimsToApprove", method = RequestMethod.POST)
	public ModelAndView processClaimApproveWindow(BindingResult result, Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("Manager/ClaimToApprove");
		Manager m = (Manager)model.get("manager");
		List<OTDetail> List = m_Service.FindClaimApplicationForApproval(m.getEmployeeID());
		mav.addObject("ClaimListForApproval", List);
		return mav;
	}*/
}
