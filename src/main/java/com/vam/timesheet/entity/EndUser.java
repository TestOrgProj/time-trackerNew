package com.vam.timesheet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class EndUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@Column(name = "id")
	private int id;
	@Column(name="emailId")
	private String emailId;

	@Column(name="password")
	private String password;

	@Column(name = "First_Name")
	private String FirstName;
	
	@Column(name = "Last_Name")
	private String LastName;
	
	@Column(name = "Total_Experience",precision=4,scale=2)
	private float TotalExperience ;
	
	@Column(name = "Vam_Experience",precision=4,scale=2)
	private float VamExperience;
	
	@Column(name = "Skill_Set")
	private String SkillSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public float getTotalExperience() {
		return TotalExperience;
	}

	public void setTotalExperience(float totalExperience) {
		TotalExperience = totalExperience;
	}

	public float getVamExperience() {
		return VamExperience;
	}

	public void setVamExperience(float vamExperience) {
		VamExperience = vamExperience;
	}

	public String getSkillSet() {
		return SkillSet;
	}

	public void setSkillSet(String skillSet) {
		SkillSet = skillSet;
	}

//	@ManyToOne
//	@JoinColumn(name = "TsId")
//	private Timesheet timesheet;
//	
	
	
	
	
	
	
	
	public EndUser(int id, String emailId, String password, String firstName, String lastName, float totalExperience,
			float vamExperience, String skillSet) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		FirstName = firstName;
		LastName = lastName;
		TotalExperience = totalExperience;
		VamExperience = vamExperience;
		SkillSet = skillSet;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", TotalExperience=" + TotalExperience + ", VamExperience=" + VamExperience
				+ ", SkillSet=" + SkillSet + "]";
	}

	public EndUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}