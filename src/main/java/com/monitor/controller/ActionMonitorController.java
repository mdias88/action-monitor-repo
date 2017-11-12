package com.monitor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.entities.LoginInfo;
import com.monitor.services.ActionMonitorServices;

@Controller
public class ActionMonitorController {

	private static final Logger logger = LoggerFactory.getLogger(ActionMonitorController.class);
	 
	@Autowired
	private ActionMonitorServices actionMonitorServices;
	

	@RequestMapping("/")
	public ModelAndView onStart(HttpServletRequest request) {

		logger.info("Begin ActionMonitorController");
 
		ModelAndView mv = new ModelAndView("home");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/Insert")
	public void  insertNewAccount(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "userNameInsert", required = false, defaultValue = "userNameInsert") String userName,
			@RequestParam(value = "passwordInsert", required = false, defaultValue = "passwordInsert") String password) throws IOException {

		logger.info("insertNewAccount: userName = " + userName + " and password = " + password);
		response.setContentType("text/plain");
		
		try{			
			if(StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)){
				LoginInfo loginInfo = new LoginInfo(userName, password, "TEST_OPER");
				actionMonitorServices.insertLoginInfo(loginInfo);
				response.setStatus(200);
				response.getWriter().printf("OK");
			}else{
				logger.error("ActionMonitorController - insertNewAccount - Unexpected values recieved on controller method.");
				response.setStatus(400);
				response.getWriter().printf("NOK");
			}
		}catch(Exception e){
			response.setStatus(400);
			response.getWriter().printf(e.getMessage());
		}	
		response.getWriter().flush();
		
	}
	
	@ResponseBody
	@RequestMapping("/Update")
	public void  updateAccount(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "userNameUpdate", required = false, defaultValue = "userNameUpdate") String userName,
			@RequestParam(value = "passwordUpdate", required = false, defaultValue = "passwordUpdate") String password) throws IOException {

		logger.info("updateAccount: userName = " + userName + " and password = " + password);
		response.setContentType("text/plain");
		
		try{			
			if(StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)){
				actionMonitorServices.updateLoginInfo(userName, password);
				response.setStatus(200);
				response.getWriter().printf("OK");
			}else{
				logger.error("ActionMonitorController - updateAccount - Unexpected values recieved on controller method.");
				response.setStatus(400);
				response.getWriter().printf("NOK");
			}
		}catch(Exception e){
			response.setStatus(400);
			response.getWriter().printf(e.getMessage());
		}	
		response.getWriter().flush();
		
	}
	
	@ResponseBody
	@RequestMapping("/Delete")
	public void  deleteAccount(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "userNameDelete", required = false, defaultValue = "userNameDelete") String userName) throws IOException{
		logger.info("deleteAccount: userName = " + userName);
		response.setContentType("text/plain");
		
		try{			
			if(StringUtils.isNotEmpty(userName)){
				actionMonitorServices.deleteLoginInfo(userName);
				response.setStatus(200);
				response.getWriter().printf("OK");
			}else{
				logger.error("ActionMonitorController - deleteAccount - Unexpected values recieved on controller method.");
				response.setStatus(400);
				response.getWriter().printf("NOK");
			}
		}catch(Exception e){
			response.setStatus(400);
			response.getWriter().printf(e.getMessage());
		}	
		response.getWriter().flush();
		
	}
	
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public @ResponseBody List<LoginInfo> showUserLoginInfoContent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("Begin showUserLoginInfoContent");
		return actionMonitorServices.getAllLoginInfo();
	}
	
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public @ResponseBody String findVersion(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("Begin findVersion");
		String version = getClass().getPackage().getImplementationVersion();
		return version;
	}
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public @ResponseBody String findStatus(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("Begin findStatus");
		JSONObject statusObj = new JSONObject();
		statusObj.put("status", "UP");
		return statusObj.toString();
	}
		
}
 