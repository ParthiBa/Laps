package com.team6.LapsApp.Web.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team6.LapsApp.Web.Controllers.Validator.LoginSess;
import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.EmployeeBase;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveDetailCompositeID;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
	
	@Autowired
	private LeaveApplicationService m_Service;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	@Autowired
    public ManagerController(LeaveApplicationService Service) {
        this.m_Service = Service;
    }
	
	@RequestMapping(value = "/InitManagerWindow", method = RequestMethod.GET)
	public String InitManagerWindow(Map<String, Object> model) {
        return "ManagerHomePage";
	}
	
	@RequestMapping(value = "/InitManagerLeaveApproveWindow", method = RequestMethod.GET)
	public String InitManagerLeaveApproveWindow(Map<String, Object> model,HttpSession session) {
        LoginSess ls = (LoginSess)session.getAttribute("login");
        
        EmployeeBase e = null;
        if(ls.getRoleID().equalsIgnoreCase("M") == true)
        	e = new Manager();
        else if (ls.getRoleID().equalsIgnoreCase("E") == true)
        	e = new Employee();
        
        e.setEmployeeID(ls.getEmpiD());
		e = (Manager) m_Service.findManagerByID(e.getEmployeeID());
	    model.put("manager", e);
        return "Manager/LeaveToApprove";
	}
	
	@RequestMapping(value = "/InitManagerClaimApproveWindow", method = RequestMethod.GET)
	public String InitManagerClaimApproveWindow(Map<String, Object> model,HttpSession session) {
		LoginSess ls = (LoginSess)session.getAttribute("login");
        
        EmployeeBase e = null;
        if(ls.getRoleID().equalsIgnoreCase("M") == true)
        	e = new Manager();
        else if (ls.getRoleID().equalsIgnoreCase("E") == true)
        	e = new Employee();
        
        e.setEmployeeID(ls.getEmpiD());
		e = (Manager) m_Service.findManagerByID(e.getEmployeeID());
	    model.put("manager", e);
        return "Manager/ClaimToApprove";
	}
	
	@RequestMapping(value = "/approveorreject", method = RequestMethod.POST)
	public String approveorreject(@RequestParam String buttonName
									,@RequestParam String empid
								    ,@RequestParam Date date){
		
		LeaveDetailCompositeID ldkey = new LeaveDetailCompositeID(empid,date);
		LeaveDetail ld = m_Service.GetLeaveById(ldkey);
		
		if(buttonName.equalsIgnoreCase(",0"))
			ld.setLeaveStatus("Rejected");
		else
			ld.setLeaveStatus("Approved");
		
		m_Service.LeaveDetailsUpdate(ld);
		
		return "redirect:/manager/InitManagerLeaveApproveWindow";
    }
}
