package com.dao.services;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.entities.LoginInfo;

public class DataBaseTest extends DataBaseInit {

	@Autowired
	@InjectMocks
	private DataAccessService dataAccessService;
	
	@Autowired
	@InjectMocks
	private DataDefinitionService dataDefinitionService;
	
	@Test
	public void testDB() {
		try {
			
			//Check if DB is ready to use
			if(entityManager == null){
				fail("DB is not defined");
			}
			
			DataAccessService dataAccessService = new DataAccessServiceImpl(entityManager);
			DataDefinitionService dataDefinitionService = new DataDefinitionServiceImpl(entityManager);

			//Check if DB is empty
			List<LoginInfo> resultList = dataAccessService.getAllLoginInfo();
			if(resultList.size() > 0){
				fail("DB is not empty");
			}
			
			//Add a dummy row
			LoginInfo loginInfo = new LoginInfo("TestId", "1234", "TestUser");
			entityManager.getTransaction().begin();
			dataDefinitionService.insert(loginInfo);
			entityManager.getTransaction().commit();
			
			//Add a dummy row
			LoginInfo result = dataAccessService.getLoginInfoByUserId("TestId");
			if(result == null){
				fail("Cannot find dummy row previously inserted");
			}
			
			//Soft delete
			entityManager.getTransaction().begin();
			dataDefinitionService.softDelete("TestId");
			entityManager.getTransaction().commit();
			
			resultList = dataAccessService.getAllLoginInfo();
			if(resultList.size() != 1){
				fail("DB change size after softDelete");
			}
			
			result = dataAccessService.getLoginInfoByUserId("TestId");
			if(result != null){
				fail("Found a deleted user");
			}
			
			//Hard delete
			entityManager.getTransaction().begin();
			dataDefinitionService.hardDelete("TestId");
			entityManager.getTransaction().commit();
			
			resultList = dataAccessService.getAllLoginInfo();
			if(resultList.size() != 0){
				fail("DB don't change size after hardDelete");
			}
			 
        } catch (Exception e) {
        	fail("Generic Error testind DAO methods");
        }		
	}

}
