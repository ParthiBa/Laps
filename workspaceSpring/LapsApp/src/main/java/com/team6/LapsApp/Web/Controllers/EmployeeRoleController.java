package com.team6.LapsApp.Web.Controllers;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team6.LapsApp.model.EmployeeRole;
import com.team6.LapsApp.service.LeaveApplicationService;
import com.team6.LapsApp.service.LeaveApplicationServiceImpl;


@Controller
@RequestMapping(value = "/EProle")
public class EmployeeRoleController {
	
	@Resource
	private LeaveApplicationService empService;
	
    
	@RequestMapping(value ="/create", method=RequestMethod.GET)
	public ModelAndView CreateEmployeeRolePage()
	{
	
		ModelAndView mav= new ModelAndView("Admin/CreateEmployeeRole","EmployeeRole",new EmployeeRole());
//		  mav.addObject("LeaveTypeList", leavetypeRepo.findAll());
		return mav;
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView CreateEmployeeRole(@ModelAttribute  EmployeeRole empRole,final RedirectAttributes rdtAtte)
	{

//		if (( result).hasErrors()){
//  		String	message="error";
//  		rdtAtte.addFlashAttribute("message", message);
//			return new ModelAndView("CreateLeaveType");
//	  
//		}
		ModelAndView mav = new ModelAndView();
		String message = "New Role " + empRole.getRoleType() + " was successfully created.";

		empService.CreateEmpRole(empRole);
//		String s="create";
//		mav.addObject("actiont",s);
		
		mav.setViewName("AdminHomePage");
       
		rdtAtte.addFlashAttribute("message", message);
		return mav;
	}
	
	
	@RequestMapping(value="/All",method=RequestMethod.GET)
	public ModelAndView AllEmployeeRole(Map<String, Object> model)
	{
    	ModelAndView mav=new ModelAndView("Admin/ListOfRoles");
    	
    	List<EmployeeRole> list=empService.findAllEmployeeRole();
		
		mav.addObject("EmpolyeeRoleList", list);
		
        return mav;
	}
	
	 @RequestMapping(value = "/Delete/{roleId}", method = RequestMethod.GET)
	    public ModelAndView DeleteEmployeeRole(@PathVariable String roleId, final RedirectAttributes redirectAttributes)
			       
	    {
	    	ModelAndView ar=new ModelAndView();

	    	EmployeeRole empRole = empService.deleteEmployeeRole(roleId);
			String message =empRole.getRoleType() +  "has been delected from records";

			ar.setViewName("AdminHomePage");
			
			redirectAttributes.addFlashAttribute("message", message);
			return ar;

	    	
	    }

}
