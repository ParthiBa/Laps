package com.team6.LapsApp.Web.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team6.LapsApp.Web.Controllers.Validator.*;
import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.repository.RoleIDReposistory;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private LeaveApplicationService empService;
	
	@Autowired
	private RoleIDReposistory roleRepo;

	@Autowired
	private EmployeeValidator employeeValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 dateFormat.setLenient(true);
		 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		 binder.setValidator(employeeValidator);
	}
	
	@RequestMapping(value ="/CreateEmployee", method=RequestMethod.GET)
	public ModelAndView createEmployeepage()
	{
	
		ModelAndView mav= new ModelAndView("Admin/CreateOrUpdateEmployee","employee",new Employee());
		  mav.addObject("roleList", roleRepo.findAll());
		  mav.addObject("SupervisorList",empService.ListOfSuperVisor());
		return mav;
		
	}
	
	@RequestMapping(value="/CreateEmployee",method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute @Valid Employee employee,BindingResult result,final RedirectAttributes rdtAtte)
	{

		if (( result).hasErrors()){
		String	message="error";
		rdtAtte.addFlashAttribute("message", message);
			return new ModelAndView("Admin/CreateOrUpdateEmployee");
	  
		}
		ModelAndView mav = new ModelAndView();
		String message = "New Employee " + employee.getEmployeename()
				+ " was successfully created.";

		empService.CreateEmployeeID(employee);
		String s="create";
		mav.addObject("actiont",s);
		
		mav.setViewName("home");
       
		rdtAtte.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/SearchEmployee",method=RequestMethod.GET)
	public String SearchEmployee(Map<String, Object> model)
	{
		model.put("employee", new Employee());
        return "SearchEmployee";
	}
	
	@RequestMapping(value="/SearchEmployee",method=RequestMethod.POST)
	public ModelAndView returnSearchEmployee( Employee emp,Map<String, Object> model)
	{
		ModelAndView mav = new ModelAndView("More Options/SearchEmployee");

		List<Employee> list=empService.SearchEmpbyName( emp.getEmployeename());
		mav.addObject("employeeList", list);
		return mav;
	}
	
	
    @RequestMapping(value = "/edit/{employeeID}", method = RequestMethod.GET)
    public ModelAndView initUpdateOwnerForm(@PathVariable("employeeID") String employeeID, Model model) {
//        Owner owner = this.clinicService.findOwnerById(ownerId);
//        model.addAttribute(owner);
//        return "owners/createOrUpdateOwnerForm";
    	Employee e = empService.findEmployee(employeeID);
		ModelAndView mav= new ModelAndView("Admin/CreateOrUpdateEmployee","employee",e);
		String s="edit";
		mav.addObject("actiont", s);
		  mav.addObject("roleList", roleRepo.findAll());
		  mav.addObject("SupervisorList",empService.ListOfSuperVisor());
       return mav;
    }

    @RequestMapping(value = "/edit/{employeeID}", method = RequestMethod.PUT)
    public String processUpdateOwnerForm(Map<String, Object> model,@Valid Employee emp, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "Admin/createOrUpdateOwnerForm";
        } else {
           
            status.setComplete();
             empService.updateEmployeeDetails(emp);
            return "home";
        }
    }
    
    @RequestMapping(value="/AllEmployee",method=RequestMethod.GET)
	public ModelAndView AllEmployee(Map<String, Object> model)
	{
    	ModelAndView mav=new ModelAndView();
    	
    	List<Employee> list=empService.FindAllEmployee();
		
		mav.addObject("employeeList", list);
		mav.setViewName("AllEmployee");
    return mav;
	}
    
    
    @RequestMapping(value = "/delete/{empid}", method = RequestMethod.GET)
    public ModelAndView DeleteEmp(@PathVariable String empid, final RedirectAttributes redirectAttributes)
		       
    {
    	ModelAndView ar=new ModelAndView("redirect:/home.html");


		Employee e= empService.DeleteEmployeeID(empid);
		String message =e.getEmployeename()+  "has been delected from records";

		redirectAttributes.addFlashAttribute("message", message);
		return ar;

    	
    }
	
	
	
	
}
