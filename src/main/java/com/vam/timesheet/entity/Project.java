package com.vam.timesheet.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Projects")

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_generator")
	@Column(name = "PId")
	private int id;

	@Column(name = "Name")
	private String name;
	@Column(name = "Status")
	private String status;
	@Column(name = "createDate")
	private Date createDate = new Date(System.currentTimeMillis());

	// creating a relation for projects and tickets.
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.LAZY)
	private List<Ticket> ticket;
	// @JsonManagedReference
//		public List<Tickets> getTickets() {
//			return tickets;
//		}
//
//		public void setTickets(List<Tickets> tickets) {
//			this.tickets = tickets;
//		}

	public int getId() {
		return id;
	}

	public void setId(int projectId) {
		this.id = projectId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Project(int projectId, String name, String status, Date createDate) {
		super();
		this.id = projectId;
		this.name = name;
		this.status = status;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + id + ", Name=" + name + ", Status=" + status + ", createDate="
				+ createDate + "]";
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

}