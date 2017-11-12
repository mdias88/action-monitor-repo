package com.dao.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.entities.LogDBAction;
import com.dao.entities.LoginInfo;


@Repository
public class DataDefinitionServiceImpl implements DataDefinitionService {
	 @PersistenceContext
	 private EntityManager entityManager;
		
	@Autowired
	 private DataAccessService dataAccessService;
	
	//ADD the constructor to inject entetyManager in unit tests
	 public DataDefinitionServiceImpl( EntityManager entityManager) {
		 super();
		 this.entityManager = entityManager;
		 if(dataAccessService == null){
			 dataAccessService = new DataAccessServiceImpl(entityManager);
		 }
	 }
	 
	 public DataDefinitionServiceImpl() {
		super();
	 }


	@Override
	 public void insert(LoginInfo loginInfo) throws Exception {
		LoginInfo result = dataAccessService.getLoginInfoByUserId(loginInfo.getUserId());
		if (result == null) {
			 entityManager.persist(loginInfo);
			 
			 //LOG
			 DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String actionDesc = "At " + formatterDate.format(loginInfo.getDateCreate()) + " a row with ID=" 
			 + loginInfo.getId() + " and userId=" + loginInfo.getUserId() + " was inserted by " + loginInfo.getUserCreate();
			 LogDBAction log = new LogDBAction("insert", actionDesc);
			 entityManager.persist(log);
		}else{
			 throw new Exception("User " + loginInfo.getUserId() + " already exist!");
		 }
	 }
	 
	@Override
	 public void hardDelete(String userId)  throws Exception {
		 LoginInfo loginInfo = dataAccessService.getLoginInfoByUserId(userId, null);
		 if (loginInfo != null) {
			 entityManager.remove(loginInfo);
			 
			//LOG
			 DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String actionDesc = "At " + formatterDate.format(loginInfo.getDateCreate()) + " a row with ID=" 
			 + loginInfo.getId() + " and userId=" + loginInfo.getUserId() + " was deleted by " + loginInfo.getUserCreate();
			 LogDBAction log = new LogDBAction("delete", actionDesc);
			 entityManager.persist(log);
		 }else{
			 throw new Exception("User " + userId + " doesn't exist!");
		 }
	 }
	
	@Override
	 public void hardDelete(LoginInfo loginInfo)  throws Exception {
		 entityManager.remove(loginInfo);
		 
		//LOG
		 DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String actionDesc = "At " + formatterDate.format(loginInfo.getDateCreate()) + " a row with ID=" 
		 + loginInfo.getId() + " and userId=" + loginInfo.getUserId() + " was deleted by " + loginInfo.getUserCreate();
		 LogDBAction log = new LogDBAction("delete", actionDesc);
		 entityManager.persist(log);
	 }
	
	@Override
	 public void softDelete(String userId)  throws Exception {
		 LoginInfo loginInfo = dataAccessService.getLoginInfoByUserId(userId);
		 if (loginInfo != null) {
			 loginInfo.setIsDeleted(true);
			 entityManager.merge(loginInfo);
			 
			//LOG
			 DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String actionDesc = "At " + formatterDate.format(loginInfo.getDateCreate()) + " a row with ID=" 
			 + loginInfo.getId() + " and userId=" + loginInfo.getUserId() + " was deleted by " + loginInfo.getUserCreate();
			 LogDBAction log = new LogDBAction("delete", actionDesc);
			 entityManager.persist(log);
		 }else{
			 throw new Exception("User " + userId + " doesn't exist!");
		 }
	 }
	
	@Override
	 public void update(String userId, String password) throws Exception {
		 LoginInfo loginInfo = dataAccessService.getLoginInfoByUserId(userId);		
		 if (loginInfo != null) {
			 loginInfo.setUserPassword(password);
			 entityManager.merge(loginInfo);
			 
			//LOG
			 DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String actionDesc = "At " + formatterDate.format(loginInfo.getDateCreate()) + " a row with ID=" 
			 + loginInfo.getId() + " and userId=" + loginInfo.getUserId() + " was updated by " + loginInfo.getUserCreate();
			 LogDBAction log = new LogDBAction("update", actionDesc);
			 entityManager.persist(log);
		 }else{
			 throw new Exception("User " + userId + " doesn't exist!");
		 }
	 }
	
	@Override
	 public void updateLogDBAction(LogDBAction log, Boolean notificationSent){
			 log.setNotificationSent(notificationSent);
			 entityManager.merge(log);
	 }
	
	
}
