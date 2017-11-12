package com.monitor.services;

import java.util.List;

import com.dao.entities.LoginInfo;

public interface ActionMonitorServices {

	public Boolean insertLoginInfo(LoginInfo loginInfo) throws Exception;
	
	public Boolean updateLoginInfo(String userName, String password) throws Exception;
	
	public Boolean deleteLoginInfo(String userId) throws Exception;
	
	public List<LoginInfo> getAllLoginInfo() throws Exception;
}
