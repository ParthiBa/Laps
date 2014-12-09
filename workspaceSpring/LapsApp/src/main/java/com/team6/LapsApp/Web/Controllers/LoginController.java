package com.team6.LapsApp.Web.Controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team6.LapsApp.Web.Controllers.Validator.LoginSess;
import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.EmployeeBase;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.service.LeaveApplicationService;
import com.team6.LapsApp.service.UserModel;


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
	 LoginSess ls = new LoginSess();
	 ls.setRoleID("E");
	 session.setAttribute("login",ls);
	 return mav;
	}
	
	@RequestMapping(value ="/loginMngr", method=RequestMethod.GET)
	public ModelAndView createLoginManager(HttpSession session)
	{
	 ModelAndView mav=new ModelAndView("login","UserModel",new UserModel());
	 LoginSess ls = new LoginSess();
	 ls.setRoleID("M");
	 session.setAttribute("login",ls);
	 return mav;
	}
	
	@RequestMapping(value="/loginEmp",method=RequestMethod.POST)
	public ModelAndView setLoginpage(HttpSession session,@ModelAttribute  UserModel user,final RedirectAttributes rdtAtte
										)
	{
       ModelAndView mav;
       Employee e = null;
       Manager m = null;
       
       LoginSess ls = (LoginSess)session.getAttribute("login");
	   if(ls.getRoleID().equalsIgnoreCase("E"))
	   {
		   e = m_Service.findEmp(user.getEmpID(),user.getPassword());
		   if(e.getRoleID().equals("A"))
			   ls.setRoleID("A");
	   }
	   else if(ls.getRoleID().equalsIgnoreCase("M"))
	   {
//		   m = m_Service.findManagerByID(user.getEmpID());
		   m=m_Service.findManagerByUserNamePassword(user.getEmpID(),user.getPassword());
	   }
	   
	   if(ls.getRoleID().equalsIgnoreCase("E")){
		   mav = new ModelAndView("EmployeeOptions");
	   }
	   else if(ls.getRoleID().equalsIgnoreCase("A")){
		   mav = new ModelAndView("AdminHomePage");
	   }
	   else if(ls.getRoleID().equalsIgnoreCase("M")){
		   mav = new ModelAndView("ManagerHomePage");
	   }
	   else{
		   mav = new ModelAndView("login");
	   }
	   
	   boolean result = false;
	   
	   if(ls.getRoleID().equalsIgnoreCase("E") ||
			        ls.getRoleID().equalsIgnoreCase("A"))
	       result = e.getPassword().equals(user.getPassword());
	   else if(ls.getRoleID().equalsIgnoreCase("M"))
		   result = m.getPassword().equals(user.getPassword());
	   if(result == true){
		   ls.setEmpiD(user.getEmpID());
		   session.setAttribute("employeelogedin",e);
		   session.setAttribute("Managerlogedin",m);
		   return mav;	
	   }
	   else
		   mav = new ModelAndView("login");
	   
	   return mav;
	}
}
