package com.ncs.api.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name="username") 
	@NotEmpty(message = "username cannot be null")
	private String name;
	@Length(min = 5, message = "Your password must have at least 5 characters")
	private String password;
	@Column(name="role")
	@NotEmpty(message = "role cannot be null")
	private String role;
	@Column(name=" email") 
	@Email(message = "Enter Valid Email")
	@NotEmpty(message = "email cannot be null")
	private String registeredEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private Set<TestScore> scoreList;

	public User() {
		super();
	}

	public User(@NotEmpty(message = "username cannot be null") String name,
			@Length(min = 5, message = "Your password must have at least 5 characters") String password,
			@NotEmpty(message = "role cannot be null") String role,
			@Email(message = "Enter Valid Email") @NotEmpty(message = "email cannot be null") String registeredEmail) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.registeredEmail = registeredEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public Set<TestScore> getScoreList() {
		return scoreList;
	}

	public void setScoreList(Set<TestScore> scoreList) {
		this.scoreList = scoreList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registeredEmail == null) ? 0 : registeredEmail.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((scoreList == null) ? 0 : scoreList.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registeredEmail == null) {
			if (other.registeredEmail != null)
				return false;
		} else if (!registeredEmail.equals(other.registeredEmail))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (scoreList == null) {
			if (other.scoreList != null)
				return false;
		} else if (!scoreList.equals(other.scoreList))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", role=" + role
				+ ", registeredEmail=" + registeredEmail + ", scoreList=" + scoreList + "]";
	}
	
	
}
