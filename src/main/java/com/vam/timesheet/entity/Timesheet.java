package com.vam.timesheet.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Timesheet")

public class Timesheet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timesheet_generator")
	@Column(name = "tsId")
	private int id;

	@Column(name = "logHours")
	private float logHours;
	
    @Column(name = "logDesc")
	private String logDesc;
	
    @Column(name = "Sprint")
	private String Sprint;
	
    @Column(name = "logDate")
	private Date logDate = new Date(System.currentTimeMillis());
    @Column(name="logSprint")
    private String logSprint;

	// creating a relation between projects and tickets

//	@ManyToOne
//	@JoinColumn(name = "projectsId")
//	private Projects projects;
//	
//	public Projects getProjects() {
//		return projects;
//	}
//
//	public void setProjects(Projects projects) {
//		this.projects = projects;
//	}

	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "TId")
	private Ticket ticket;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

//	public int getTimesheetId() {
//		return id;
//	}
//	
//
//	public void setTimesheetId(int timesheetId) {
//		this.id = timesheetId;
//	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLogHours() {
		return logHours;
	}

	public void setLogHours(float logHours) {
		this.logHours = logHours;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

//	public String getSprint() {
//		return Sprint;
//	}
//
//	public void setSprint(String sprint) {
//		Sprint = sprint;
//	}

	public String getSprint() {
		return Sprint;
	}

	public void setSprint(String sprint) {
		Sprint = sprint;
	}

	public String getLogDesc() {
		return logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}
    
	public String getLogSprint() {
		return logSprint;
	}

	public void setLogSprint(String logSprint) {
		this.logSprint = logSprint;
	}

	public Timesheet(int id, float logHours, String logDesc, String sprint, Date logDate, String logSprint,
			Ticket ticket) {
		super();
		this.id = id;
		this.logHours = logHours;
		this.logDesc = logDesc;
		Sprint = sprint;
		this.logDate = logDate;
		this.logSprint = logSprint;
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Timesheet [id=" + id + ", logHours=" + logHours + ", logDesc=" + logDesc + ", Sprint=" + Sprint
				+ ", logDate=" + logDate + ", logSprint=" + logSprint + ", ticket=" + ticket + "]";
	}

	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}