package com.team6.LapsApp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager extends EmployeeBase{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="m_manager", fetch = FetchType.EAGER)
    private Set<LeaveDetail> m_leaveToApprove = null;
	
	@OneToMany(cascade = CascadeType.ALL)//, mappedBy="manager")
    private Set<OTDetail> m_claimsToApprove = null;
	
	protected Set<LeaveDetail> getLeavesInternal() {
        if (this.m_leaveToApprove == null) {
            this.m_leaveToApprove = new HashSet<LeaveDetail>();
        }
        return this.m_leaveToApprove;
    }
	
	protected void setLeavesInternal(Set<LeaveDetail> ld) {
        this.m_leaveToApprove = ld;
    }
	
	public void addleavestoApprove(LeaveDetail ld) {
		getLeavesInternal().add(ld);
		ld.setM_manager(this);
	}
}
