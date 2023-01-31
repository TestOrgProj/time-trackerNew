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
@Table(name = "Tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_generator")
	@Column(name = "TId")
	private int id;

	@Column(name = "key")
	private String key;
	@Column(name = "summary")
	private String summary;
	@Column(name = "assignee")
	private String assignee;
	@Column(name = "reporter")
	private String reporter;
	@Column(name = "type")
	private String type;
	@Column(name = "status")
	private String status;
	@Column(name = "resolution")
	private String resolution;
	@Column(name = "createdDate")
	private Date createdDate = new Date(System.currentTimeMillis());
	@Column(name = "storyPoint")
	private float storyPoint;
	@Column(name = "originalEstimate")
	private float originalEstimate;
	@Column(name = "epicid")
	private int epicId;
	@Column(name = "startSprint")
	private String startSprint;
	@Column(name = "endSprint")
	private String endSprint;
	@Column(name = "componet")
	private String component;

	// creating a relation between projects and tickets
	@ManyToOne
	@JoinColumn(name = "PId")
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
//	private List<Timesheet> timesheet;

//	public int getTicketId() {
//		return id;
//	}
//
//	public void setTicketId(int id) {
//		this.id = id;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	
	

	public int getEpicId() {
		return epicId;
	}

	public void setEpicId(int epicId) {
		this.epicId = epicId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public float getStoryPoint() {
		return storyPoint;
	}

	public void setStoryPoint(float storypoint) {
		this.storyPoint = storypoint;
	}

	public float getOriginalEstimate() {
		return originalEstimate;
	}

	public void setOriginalEstimate(float originalEstimate) {
		this.originalEstimate = originalEstimate;
	}

//	public int getEpicid() {
//		return epicId;
//	}
//
//	public void setEpicid(int epicId) {
//		this.epicId = epicId;
//	}

	public String getStartSprint() {
		return startSprint;
	}

	public void setStartSprint(String startsprint) {
		this.startSprint = startsprint;
	}

	public String getEndSprint() {
		return endSprint;
	}

	public void setEndSprint(String endsprint) {
		this.endSprint = endsprint;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	
	
}