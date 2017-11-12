package com.dao.services;

import java.sql.SQLException;

import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.BeforeClass;
import org.mockito.Mock;

public class DataBaseInit {

		@PersistenceContext
		@Mock
		protected static javax.persistence.EntityManager entityManager;

	    @BeforeClass
	    public static void initDB() throws SQLException {	    	   	
	    	entityManager = Persistence.createEntityManagerFactory("actionMonitorDBtest").createEntityManager();
	    	entityManager.clear();
	    }

}
