package com.team6.LapsApp.Web.Controllers;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.model.EmployeeRole;
import com.team6.LapsApp.model.Entitlement;
import com.team6.LapsApp.model.EntitlementId;
import com.team6.LapsApp.service.LeaveApplicationService;
import com.team6.LapsApp.Web.Controllers.Validator.EntitlementValidator;


@Controller
@RequestMapping(value ="/typeOfLeave")
public class TypeOfLeaveController {
	
	@Autowired
	LeaveApplicationService leaveApplicationService;
	
	@Autowired
	EntitlementValidator EntitlementValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(EntitlementValidator);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEntitlementPage() {
		ModelAndView mav = new ModelAndView("Admin/typeOfLeave-new", "Entitlement",
				new Entitlement());
		List<EmployeeRole> roleList = leaveApplicationService.findRoleAll();
		List<LeaveType> leaveTypeList = leaveApplicationService.findLeaveAll();
		Iterator<LeaveType> i= leaveTypeList.iterator();
		int index;
		while(i.hasNext())
		{
			LeaveType a = i.next();
			if(a.getLeaveTypeName().equalsIgnoreCase("Compensation Leave"))
			{
				leaveTypeList.remove(a);
			}
		}
		mav.addObject("roleList", roleList);
		mav.addObject("leaveTypeList", leaveTypeList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEntitlement(@ModelAttribute @Valid Entitlement entitlement,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("errorPage");

		ModelAndView mav = new ModelAndView();
		String message = "New student " + entitlement.getRoleId()
				+ " was successfully created.";

		leaveApplicationService.create(entitlement);
		mav.setViewName("AdminHomePage");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView studentListPage() {
		ModelAndView mav = new ModelAndView("Admin/typeOfLeave-list");
		List<Entitlement> EntitlementList = leaveApplicationService.findAll();
		mav.addObject("EntitlementList", EntitlementList);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{rld}/{lid}", method = RequestMethod.GET)
	public ModelAndView editEntitlement(@PathVariable String rld,@PathVariable String lid) {
		ModelAndView mav = new ModelAndView("Admin/typeOfLeave-edit");
		Entitlement Entitlement =leaveApplicationService.findByOne(rld, lid);
		mav.addObject("Entitlement", Entitlement);
		return mav;
	}
	

	@RequestMapping(value = "/edit/{rld}/{lid}", method = RequestMethod.POST)
	public ModelAndView editEntitlement(@ModelAttribute @Valid Entitlement entitlement,
			BindingResult result, @PathVariable String rld,@PathVariable String lid,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("Admin/typeOfLeave-list");

		ModelAndView mav = new ModelAndView("home");
		String message = "Entitlement was successfully updated.";

		leaveApplicationService.update(entitlement);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{rld}/{lid}", method = RequestMethod.GET)
	public ModelAndView deleteEntitlement(@PathVariable String rld,@PathVariable String lid,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("home");
		Entitlement entitlement = leaveApplicationService.findByOne(rld, lid);
		leaveApplicationService.delete(entitlement);
		String message = "The entitlement " + entitlement.getRoleId()
				+ " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
