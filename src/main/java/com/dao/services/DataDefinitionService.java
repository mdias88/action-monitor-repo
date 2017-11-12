package com.dao.services;

import com.dao.entities.LogDBAction;
import com.dao.entities.LoginInfo;


public interface DataDefinitionService {
	
	 public void insert(LoginInfo loginInfo) throws Exception;
	
	 public void hardDelete(String userId) throws Exception;
	 
	 public void hardDelete(LoginInfo loginInfo)  throws Exception;

	 public void softDelete(String userId) throws Exception;
	 
	 public void update(String userId, String password) throws Exception;
	 
	 public void updateLogDBAction(LogDBAction log, Boolean notificationSent);
	
}
