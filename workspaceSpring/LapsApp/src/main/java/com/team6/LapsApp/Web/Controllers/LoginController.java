package com.team6.LapsApp.Web.Controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.service.LeaveApplicationService;
import com.team6.LapsApp.Web.Controllers.Validator.UserModel;
import com.team6.LapsApp.Web.Controllers.Validator.LoginSess;;


@Controller
@RequestMapping(value ="/Login")
public class LoginController 
{
	@Autowired
	private LeaveApplicationService m_Service;
	
	@RequestMapping(value ="/loginEmp", method=RequestMethod.GET)
	public ModelAndView createLoginEmployee(HttpSession session)
	{
	 ModelAndView mav=new ModelAndView("login","UserModel",new UserModel());
	 session.setAttribute("login",new LoginSess());
	 return mav;
	}
	
	@RequestMapping(value="/loginEmp",method=RequestMethod.POST)
	public ModelAndView setLoginpage(HttpSession session,@ModelAttribute  UserModel user,final RedirectAttributes rdtAtte)
	{
		
	    ModelAndView mav;	
	   Employee e = m_Service.findEmployee(user.getEmpID());
	   if(e.getRoleID().equalsIgnoreCase("E")){
		   mav = new ModelAndView("EmployeeOptions");
	   }
	   else if(e.getRoleID().equalsIgnoreCase("A")){
		   mav = new ModelAndView("AdminHomePage");
	   }
	   else if(e.getRoleID().equalsIgnoreCase("M")){
		   mav = new ModelAndView("ManagerHomePage");
	   }
	   else{
		   mav = new ModelAndView("login");
	   }
	   if(e.getPassword().equals(user.getPassword()));
	   {
	   	 LoginSess k=(LoginSess) session.getAttribute("login");
	   	 k.setEmpiD(e.getEmployeeID());
	   	 k.setRoleID(e.getRoleID());
	        mav.addObject("role",e.getRoleID());
	   }
		String message = "login as " + e.getEmployeename();
		mav.addObject("messages", message);
		return mav;
	}

}
