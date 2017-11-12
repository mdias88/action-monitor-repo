package com.dao.services;

import java.util.List;

import com.dao.entities.LogDBAction;
import com.dao.entities.LoginInfo;


public interface DataAccessService {
	 
	 public LoginInfo getLoginInfoById(long id);
	 
	 public List<LoginInfo> getAllLoginInfo();
	 
	 public LoginInfo getLoginInfoByUserId(String userId) throws Exception;
	 
	 public LoginInfo getLoginInfoByUserId(String userId, Boolean isDeleted) throws Exception;
	 
	 public List<LogDBAction> getAllLogDBAction();
	 
	 public List<LogDBAction> getAllLogDBActionNotNotified();
	
}	 