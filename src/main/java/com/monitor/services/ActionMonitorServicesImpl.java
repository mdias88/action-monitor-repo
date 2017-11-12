package com.monitor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.entities.LoginInfo;
import com.dao.services.DataAccessService;
import com.dao.services.DataDefinitionService;

@Service
@Transactional
public class ActionMonitorServicesImpl implements ActionMonitorServices {

	@Autowired
	private DataDefinitionService dataDefinitionService;
	
	@Autowired
	private DataAccessService dataAccessService;
	
	@Override
	public Boolean insertLoginInfo(LoginInfo loginInfo) throws Exception{
		dataDefinitionService.insert(loginInfo);
		return true;
	}
	
	@Override
	public Boolean updateLoginInfo(String userName, String password) throws Exception{
		dataDefinitionService.update(userName, password);
		return true;
	}
	
	@Override
	public Boolean deleteLoginInfo(String userId) throws Exception{
		dataDefinitionService.softDelete(userId);
		return true;
	}
	
	@Override
	public List<LoginInfo> getAllLoginInfo() throws Exception{
		return dataAccessService.getAllLoginInfo();
	}
}
