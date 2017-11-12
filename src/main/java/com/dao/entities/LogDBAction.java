package com.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logDBIaction")
public class LogDBAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String action;
	
	private String actionDesc;
	
	private Boolean notificationSent;
	
	public LogDBAction() {
		super();
	}
	
	public LogDBAction(String action, String actionDesc) {
		super();
		this.action = action;
		this.actionDesc = actionDesc;
		this.notificationSent = false;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public Boolean getNotificationSent() {
		return notificationSent;
	}

	public void setNotificationSent(Boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((actionDesc == null) ? 0 : actionDesc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((notificationSent == null) ? 0 : notificationSent.hashCode());
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
		LogDBAction other = (LogDBAction) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (actionDesc == null) {
			if (other.actionDesc != null)
				return false;
		} else if (!actionDesc.equals(other.actionDesc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notificationSent == null) {
			if (other.notificationSent != null)
				return false;
		} else if (!notificationSent.equals(other.notificationSent))
			return false;
		return true;
	}
	
}
