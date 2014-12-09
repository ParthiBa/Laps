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

import com.team6.LapsApp.model.Holiday;
import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value = "/holiday")
public class HolidayController {

	@Autowired
	private LeaveApplicationService holidayService;
	
	@RequestMapping(value ="/create", method=RequestMethod.GET)
	public ModelAndView CreateHolidayPage()
	{
	
		ModelAndView mav= new ModelAndView("Admin/CreateHoliday","holiday",new Holiday());
//		  mav.addObject("LeaveTypeList", leavetypeRepo.findAll());
		return mav;
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView CreateHoliday(@ModelAttribute  Holiday holiday,final RedirectAttributes rdtAtte)
	{

//		if (( result).hasErrors()){
//  		String	message="error";
//  		rdtAtte.addFlashAttribute("message", message);
//			return new ModelAndView("CreateLeaveType");
//	  
//		}
		ModelAndView mav = new ModelAndView();
		String message = "New Holiday " + holiday.getHolidayName()
				+ " was successfully created.";

		holidayService.CreateHoliday(holiday);
//		String s="create";
//		mav.addObject("actiont",s);
		
		mav.setViewName("home");
       
		rdtAtte.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/AllHoliday",method=RequestMethod.GET)
	public ModelAndView AllLeaveType(Map<String, Object> model)
	{
    	ModelAndView mav=new ModelAndView();
    	
    	List<Holiday> list=holidayService.GetAllHolidays();
		
		mav.addObject("HolidayList", list);
		mav.setViewName("Admin/AllHoliday");
        return mav;
	}
	
	 @RequestMapping(value = "/delete/{holidayid}", method = RequestMethod.GET)
	    public ModelAndView DeleteLeaveType(@PathVariable String holidayid, final RedirectAttributes redirectAttributes)
			       
	    {
	    	ModelAndView ar=new ModelAndView();

			Holiday holiday = holidayService.DeleteHoliday(holidayid);
			String message =holiday.getHolidayName() +  "has been delected from records";

			ar.setViewName("home");
			
			redirectAttributes.addFlashAttribute("message", message);
			return ar;

	    	
	    }
}
