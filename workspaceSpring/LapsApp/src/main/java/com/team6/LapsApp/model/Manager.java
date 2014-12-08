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
    public Set<LeaveDetail> m_leaveToApprove = null;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="m_manager", fetch = FetchType.EAGER)
    private Set<OTDetail> m_claimsToApprove = null;
	
	protected Set<LeaveDetail> getLeavesInternal() {
        if (this.m_leaveToApprove == null) {
            this.m_leaveToApprove = new HashSet<LeaveDetail>();
        }
        return this.m_leaveToApprove;
    }
	
	public Set<LeaveDetail> getM_leaveToApprove() {
		return m_leaveToApprove;
	}

	public void setM_leaveToApprove(Set<LeaveDetail> m_leaveToApprove) {
		this.m_leaveToApprove = m_leaveToApprove;
	}

	public Set<OTDetail> getM_claimsToApprove() {
		return m_claimsToApprove;
	}

	public void setM_claimsToApprove(Set<OTDetail> m_claimsToApprove) {
		this.m_claimsToApprove = m_claimsToApprove;
	}

	protected void setLeavesInternal(Set<LeaveDetail> ld) {
        this.m_leaveToApprove = ld;
    }
	
	public void addleavestoApprove(LeaveDetail ld) {
		getLeavesInternal().add(ld);
		ld.setM_manager(this);
	}
}
