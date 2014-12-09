package com.team6.LapsApp.Web.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value="/leavetype")
public class LeaveTypeController {
	@Autowired
	private LeaveApplicationService leaveTypeService;
	
	@RequestMapping(value ="/create", method=RequestMethod.GET)
	public ModelAndView createLeaveTypepage()
	{
	
		ModelAndView mav= new ModelAndView("CreateLeaveType","leaveType",new LeaveType());
//		  mav.addObject("LeaveTypeList", leavetypeRepo.findAll());
		return mav;
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView createLeaveType(@ModelAttribute  LeaveType leaveType,final RedirectAttributes rdtAtte)
	{

//		if (( result).hasErrors()){
//  		String	message="error";
//  		rdtAtte.addFlashAttribute("message", message);
//			return new ModelAndView("CreateLeaveType");
//	  
//		}
		ModelAndView mav = new ModelAndView();
		String message = "New LeaveType " + leaveType.getLeaveTypeName()
				+ " was successfully created.";

		leaveTypeService.CreateLeaveType(leaveType);
//		String s="create";
//		mav.addObject("actiont",s);
		
		mav.setViewName("home");
       
		rdtAtte.addFlashAttribute("message", message);
		return mav;
	}
	
	
	@RequestMapping(value="/AllLeaveType",method=RequestMethod.GET)
	public ModelAndView AllLeaveType(Map<String, Object> model)
	{
    	ModelAndView mav=new ModelAndView();
    	
    	List<LeaveType> list= leaveTypeService.GetAllLeaveTypes();
		
		mav.addObject("LeaveTypeList", list);
		mav.setViewName("AllLeaveType");
        return mav;
	}
	
	 @RequestMapping(value = "/delete/{leavetypeid}", method = RequestMethod.GET)
	    public ModelAndView DeleteLeaveType(@PathVariable String leavetypeid, final RedirectAttributes redirectAttributes)
			       
	    {
	    	ModelAndView ar=new ModelAndView();

			LeaveType leavetype = leaveTypeService.DeleteLeaveType(leavetypeid);
			String message =leavetype.getLeaveTypeName() +  "has been delected from records";

			ar.setViewName("home");
			
			redirectAttributes.addFlashAttribute("message", message);
			return ar;

	    	
	    }
}
