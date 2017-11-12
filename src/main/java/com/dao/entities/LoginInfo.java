package com.dao.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userLoginInfo")
public class LoginInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String userId;
	
	private String userPassword;
	
	private Date dateCreate;
	
	private String userCreate;
	
	private Date dateLastMod;
	
	private String userLastMod;
	
	private Boolean notificationSent;
	
	private Boolean isDeleted;
	
	
	public LoginInfo() {
		super();
	}

	public LoginInfo(String userId, String userPassword, String userCreate) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.dateCreate = new Date();
		this.userCreate = userCreate;
		this.dateLastMod = new Date();
		this.userLastMod = userCreate;
		this.notificationSent = false;
		this.isDeleted = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public Date getDateLastMod() {
		return dateLastMod;
	}

	public void setDateLastMod(Date dateLastMod) {
		this.dateLastMod = dateLastMod;
	}

	public String getUserLastMod() {
		return userLastMod;
	}

	public void setUserLastMod(String userLastMod) {
		this.userLastMod = userLastMod;
	}

	public Boolean getNotificationSent() {
		return notificationSent;
	}

	public void setNotificationSent(Boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreate == null) ? 0 : dateCreate.hashCode());
		result = prime * result + ((dateLastMod == null) ? 0 : dateLastMod.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((notificationSent == null) ? 0 : notificationSent.hashCode());
		result = prime * result + ((userCreate == null) ? 0 : userCreate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLastMod == null) ? 0 : userLastMod.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
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
		LoginInfo other = (LoginInfo) obj;
		if (dateCreate == null) {
			if (other.dateCreate != null)
				return false;
		} else if (!dateCreate.equals(other.dateCreate))
			return false;
		if (dateLastMod == null) {
			if (other.dateLastMod != null)
				return false;
		} else if (!dateLastMod.equals(other.dateLastMod))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDeleted == null) {
			if (other.isDeleted != null)
				return false;
		} else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (notificationSent == null) {
			if (other.notificationSent != null)
				return false;
		} else if (!notificationSent.equals(other.notificationSent))
			return false;
		if (userCreate == null) {
			if (other.userCreate != null)
				return false;
		} else if (!userCreate.equals(other.userCreate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLastMod == null) {
			if (other.userLastMod != null)
				return false;
		} else if (!userLastMod.equals(other.userLastMod))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", userId=" + userId + ", userPassword=" + userPassword + ", dateCreate="
				+ dateCreate + ", userCreate=" + userCreate + ", dateLastMod=" + dateLastMod + ", userLastMod="
				+ userLastMod + ", isDeleted=" + isDeleted + "]";
	}
	
}
