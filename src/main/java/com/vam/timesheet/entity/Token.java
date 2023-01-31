package com.vam.timesheet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token {
    @Id
    private String token;

    @Column(name = "user_id")
    private Long userId;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Token(String token, Long userId) {
		super();
		this.token = token;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Tokens [token=" + token + ", userId=" + userId + "]";
	}

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

    
   
}

