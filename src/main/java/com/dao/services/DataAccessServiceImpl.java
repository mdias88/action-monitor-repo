package com.dao.services;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.entities.LogDBAction;
import com.dao.entities.LoginInfo;

@Repository
@Service("dataAccessService")
public class DataAccessServiceImpl implements DataAccessService{
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	//ADD the constructor to inject entetyManager in unit tests
	 public DataAccessServiceImpl( EntityManager entityManager) {
		 super();
		 this.entityManager = entityManager;
	 }
	 
	 public DataAccessServiceImpl() {
		super();
	 }

	@Override
	 public LoginInfo getLoginInfoById(long id) {
		 return entityManager.find(LoginInfo.class, id);
	 }
	
	 @SuppressWarnings("unchecked")
	 @Override
	 public List<LoginInfo> getAllLoginInfo(){
		 return (List<LoginInfo>) entityManager.createQuery("Select t from LoginInfo t").getResultList();
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 public List<LogDBAction> getAllLogDBAction(){
		 return (List<LogDBAction>) entityManager.createQuery("Select t from LogDBAction t").getResultList();
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 public List<LogDBAction> getAllLogDBActionNotNotified(){	 
		 Query query = entityManager.createQuery("Select t from LogDBAction t WHERE t.notificationSent = :notificationSent");
		 query.setParameter("notificationSent", Boolean.FALSE);
		 return (List<LogDBAction>) query.getResultList();
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 public LoginInfo getLoginInfoByUserId(String userId) throws Exception{
		 return getLoginInfoByUserId(userId, Boolean.FALSE);
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 public LoginInfo getLoginInfoByUserId(String userId, Boolean isDeleted) throws Exception{
		 
		 Query query = null;
		 
		 if(isDeleted == null){
			 query = entityManager.createQuery("Select t from LoginInfo t WHERE t.userId = :userId");
		 }else{
			 query = entityManager.createQuery("Select t from LoginInfo t WHERE t.userId = :userId AND t.isDeleted = :isDeleted");
			 query.setParameter("isDeleted", isDeleted);
		 }
		 
		 query.setParameter("userId", userId);
				 
		 List<LoginInfo> resultList = query.getResultList();
		 
		 if(resultList.size() == 0){
			 return null;
		 }
		 else if(resultList.size() > 1){
			 throw new Exception("Two users found with same userId!");
		 }
		 
		 return resultList.get(0);
	 }
	 
}
