package com.team6.LapsApp.Web.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.team6.LapsApp.Web.Controllers.Validator.LoginSess;
import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.EmployeeBase;
import com.team6.LapsApp.model.EntitlementId;
import com.team6.LapsApp.model.Holiday;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.repository.EntilementReposistory;
import com.team6.LapsApp.repository.HolidayReposistory;
import com.team6.LapsApp.repository.LeaveTypeRepository;
import com.team6.LapsApp.repository.OTDetailsCRUDRepository;
import com.team6.LapsApp.repository.RoleIDReposistory;
import com.team6.LapsApp.repository.SpringLeaveDetailsJpa;
import com.team6.LapsApp.service.LeaveApplicationService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private LeaveApplicationService m_Service;
	@Resource
	private EntilementReposistory Entitlement; 
	@Resource
	private RoleIDReposistory roleIDrepo;
	@Resource
	private LeaveTypeRepository ltyperepo;
	@Resource
	private SpringLeaveDetailsJpa m_repository;
	@Resource
	private OTDetailsCRUDRepository OvertTimeRepo;
	@Resource 
	private HolidayReposistory holidayRepo;


	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	public Boolean ValidateLeaveApproval(LeaveDetail LD) {
//		String currentLeaveType = ltyperepo.findOne(LD.getLeaveTypeID())
//				.getLeaveTypeID();
		String currentLeaveType=ltyperepo.findByLeavetype(LD.getLeaveTypeID()).getLeaveTypeId();
//		String currentRoleType = roleIDrepo.findOne(LD.getRoleID())
//				.getRoleType();
		String currentRoleType = roleIDrepo.findByRoleID(LD.getRoleID()).getRoleId();
		EntitlementId Id = new EntitlementId(LD.getRoleID(),
				LD.getLeaveTypeID());
	
		List<LeaveDetail> list = m_repository.ListofleaveTaken(
				LD.getEmployeeID(), "Medical Leave");
		int numberofDaystaken = list.size();
		com.team6.LapsApp.model.Entitlement hisLeaveQutoa = Entitlement
				.findOne(Id);
		int numberofDaysquota = hisLeaveQutoa.getNumOfDays();
		int Days_want = (int) (((LD.getFromDate().getTime()) - (LD.getToDate()
				.getTime())) / (24 * 60 * 60 * 1000));
		List<Date> Days_accepted;
		if (currentLeaveType.equalsIgnoreCase("Medical Leave")) {
	
			if ((numberofDaysquota - numberofDaystaken) >= 0) {
				LD.setLeaveStatus("Applied");
				m_repository.save(LD);
			}
	
		} else if (currentLeaveType == "Annual Leave") {
			if (Days_want <= 14) {
				Days_accepted = isHoliday(LD.getFromDate(), LD.getToDate());
				LD.setFromDate(Days_accepted.get(0));
				int index = Days_accepted.size() - 1;
				LD.setToDate(Days_accepted.get(index));
				m_repository.save(LD);
			} else {
				m_repository.save(LD);
			}
	
		} else if (currentLeaveType == "Compensation Leave") {
			List<OTDetail> OTlist = OvertTimeRepo.findleave(LD.getEmployeeID());
			if (OTlist.size() > 0) {
				m_repository.save(LD);
				return true;
			}
		}
		return false;
	}
	
	
	private List<Date> isHoliday(Date from,Date to)
	{  
		List<Holiday> list = (List<Holiday>) holidayRepo.findAll();
		Iterator<Holiday> i = list.iterator();
		List<Date> finalList = new ArrayList<Date>();
		List<Date> HolidayList = new ArrayList<Date>();
		List<Date> AppliedLeave = new ArrayList<Date>();
		Iterator<Date> j = AppliedLeave.iterator();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(to);
		calendar.add(Calendar.DATE, 1);
		Date toDate = calendar.getTime();
		calendar.setTime(from);

		while (calendar.getTime().before(toDate)) {
			Date result = calendar.getTime();
			int dow = calendar.get(Calendar.DAY_OF_WEEK);
			if ((dow >= Calendar.MONDAY) && (dow <= Calendar.FRIDAY))
				;
			{
				AppliedLeave.add(result);
			}
			calendar.add(Calendar.DATE, 1);
		}

		while (i.hasNext()) {
			Holiday holiday = ((Holiday) i.next());
			Date HfromDate = holiday.getStartDate();
			Date HtoDate = holiday.getEndDate();
			if (HfromDate.equals(HtoDate)) {
				HolidayList.add(HfromDate);
			} else {
				calendar.setTime(HfromDate);
				while (calendar.getTime().before(HtoDate)) {
					Date result = calendar.getTime();
					HolidayList.add(result);
					calendar.add(Calendar.DATE, 1);
				}
			}
		}

		Iterator<Date> hI = HolidayList.iterator();
		while (hI.hasNext()) {
			Date holi = (Date) hI.next();
			while (j.hasNext()) {
				Date app = (Date) j.next();
				if (!(holi.equals(app))) {
					finalList.add(app);
				}
			}
		}

		return finalList;
    }
	
	@RequestMapping(value = "/newLeave", method = RequestMethod.GET)
    public String initLeaveCreationForm(@Param ("EmployeeID") String empid,Map<String, Object> model,HttpSession session) {
        LeaveDetail ld = new LeaveDetail();
        LoginSess ls = (LoginSess)session.getAttribute("login");
        
        EmployeeBase e = null;
        if(ls.getRoleID().equalsIgnoreCase("M") == true)
        	e = new Manager();
        else if (ls.getRoleID().equalsIgnoreCase("E") == true)
        	e = new Employee();
        
        e = m_Service.findEmployee(ls.getEmpiD());
        
        List<LeaveType> LeaveTypeNameList = m_Service.GetAllLeaveTypes();
        List<String> LeaveStatusList = new ArrayList<String>();
        LeaveStatusList.add("Appplied");
        LeaveStatusList.add("Cancel");

        model.put("LeaveTypeNameList", LeaveTypeNameList);
        model.put("LeaveStatusList", LeaveStatusList);
        model.put("employeelogedin", e);
        model.put("leave", ld);
        return "ApplyLeave";
    }

    @RequestMapping(value = "{EmployeeID}/newLeave", method = RequestMethod.POST)
    public String processLeaveCreationForm(@Param ("EmployeeID") String EmployeeID,@Valid LeaveDetail ld, BindingResult result, SessionStatus status) {
    	
    	/*if(ValidateLeaveApproval(ld) == false)
    		return "ApplyLeave";*/
   	
    	Manager m= this.m_Service.findbykey(ld.getM_manager().getEmployeeID());
		m.addleavestoApprove(ld);
		Employee e = this.m_Service.findEmployee(ld.getEmployeeID());
		e.addPersonalLeaves(ld);
		ld.setRoleID(e.getRoleID());
		ld.setM_empbase(e);
	    this.m_Service.ApplyLeave(ld);
	    status.setComplete();
	    return "redirect:/employee/GetPersonalLeaveHIstory";
    }
    
    @RequestMapping(value = "/newClaim", method = RequestMethod.GET)
    public String initClaimCreationForm(@Param ("EmployeeID") String empid,Map<String, Object> model,HttpSession session) {
        OTDetail ot = new OTDetail();
        LoginSess ls = (LoginSess)session.getAttribute("login");
        
        EmployeeBase e = null;
        if(ls.getRoleID().equalsIgnoreCase("M") == true)
        	e = new Manager();
        else if (ls.getRoleID().equalsIgnoreCase("E") == true)
        	e = new Employee();
        
        e = m_Service.findEmployee(ls.getEmpiD());
        model.put("employeelogedin", e);
        model.put("claim", ot);
        return "ClaimOverTime";
    }

    @RequestMapping(value = "{EmployeeID}/newClaim", method = RequestMethod.POST)
    public String processClaimCreationForm(@Param ("EmployeeID") String EmployeeID,@Valid OTDetail ot, BindingResult result, SessionStatus status) {
    	Manager m = this.m_Service.findbykey(ot.getM_manager().getEmployeeID());
		m.addClaimtoApprove(ot);
		Employee e = this.m_Service.findEmployee(ot.getEmployeeID());
		e.addPersonalclaims(ot);
		ot.setM_empot(e);
		
	    this.m_Service.ApplyClaim(ot);
	    status.setComplete();
	    return "EmployeeOptions";
    }

    @RequestMapping(value = "/GetPersonalLeaveHIstory", method = RequestMethod.GET)
	public String GetPersonalLeaveHIstory(@Param ("empid") String empid,
													Map<String, Object> model,
													HttpSession session) {
    	LoginSess ls = (LoginSess)session.getAttribute("login");
        
        EmployeeBase e = null;
        if(ls.getRoleID().equalsIgnoreCase("M") == true)
        	e = new Manager();
        else if (ls.getRoleID().equalsIgnoreCase("E") == true)
        	e = new Employee();
        
        e = m_Service.findEmployee(ls.getEmpiD());
        
        model.put("employeelogedin", e);
		return "PersonalLeaves";
	}
}
