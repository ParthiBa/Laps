package com.team6.LapsApp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@MappedSuperclass
public class EmployeeBase {
	@Id
	@Column(name="employeeID")
	private String employeeID;
	@Basic
	@NotNull
	@Column(name="Employeename")
	private String employeename;
	@Column(name="DOB")
	private Date dob;
	@Column(name="RoleID")
	private String roleID;
	@NotNull
	@Column(name="Password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="m_emp", fetch = FetchType.EAGER)
    public Set<LeaveDetail> m_personalLeaveHistory;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="m_empot", fetch = FetchType.EAGER)
    public Set<OTDetail> m_perosnalClaimHistory;
	
	public Set<LeaveDetail> getM_personalLeaveHistory() {
		return m_personalLeaveHistory;
	}

	public void setM_personalLeaveHistory(Set<LeaveDetail> m_personalLeaveHistory) {
		this.m_personalLeaveHistory = m_personalLeaveHistory;
	}

	public Set<OTDetail> getM_perosnalClaimHistory() {
		return m_perosnalClaimHistory;
	}

	public void setM_perosnalClaimHistory(Set<OTDetail> m_perosnalClaimHistory) {
		this.m_perosnalClaimHistory = m_perosnalClaimHistory;
	}

	protected Set<LeaveDetail> getPersonalLeavesInternal() {
        if (this.m_personalLeaveHistory == null) {
            this.m_personalLeaveHistory = new HashSet<LeaveDetail>();
        }
        return this.m_personalLeaveHistory;
    }
	
	protected Set<OTDetail> getPersonalClaimsInternal() {
        if (this.m_perosnalClaimHistory == null) {
            this.m_perosnalClaimHistory = new HashSet<OTDetail>();
        }
        return this.m_perosnalClaimHistory;
    }

    public List<LeaveDetail> getPersonalLeave() {
        List<LeaveDetail> sortedleaves = new ArrayList<LeaveDetail>(getPersonalLeavesInternal());
        PropertyComparator.sort(sortedleaves, new MutableSortDefinition("FromDate", true, true));
        return Collections.unmodifiableList(sortedleaves);
    }

    public void addPersonalLeaves(LeaveDetail ld) {
    	getPersonalLeavesInternal().add(ld);
    }
    
    public void addPersonalclaims(OTDetail ot) {
    	getPersonalClaimsInternal().add(ot);
    }
    
    protected Set<OTDetail> getOTListInternal() {
        if (this.m_perosnalClaimHistory == null) {
            this.m_perosnalClaimHistory = new HashSet<OTDetail>();
        }
        return this.m_perosnalClaimHistory;
    }

    public List<OTDetail> getOTdetailsList() {
        List<OTDetail> sortedclaims = new ArrayList<OTDetail>(getOTListInternal());
        PropertyComparator.sort(sortedclaims, new MutableSortDefinition("ISApproved", true, true));
        return Collections.unmodifiableList(sortedclaims);
    }

    public void addOTDetails(OTDetail ot) {
    	getOTListInternal().add(ot);
    }
    
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
