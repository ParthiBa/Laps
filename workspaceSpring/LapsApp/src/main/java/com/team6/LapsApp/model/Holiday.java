package com.team6.LapsApp.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="Holidays")
public class Holiday {

	@Id
	@Column(name="HolidayName")
	private String holidayName;
	@Basic
	@Column(name="startDate")
	private Date startDate;
	@Column(name="endDate")
	private Date endDate;
	
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
