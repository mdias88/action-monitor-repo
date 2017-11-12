package com.monitor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.dao.entities.LogDBAction;
import com.dao.services.DataAccessService;
import com.dao.services.DataDefinitionService;

@Controller
public class WebSocketHandler {
	
	@Autowired
	 private DataAccessService dataAccessService;
	
	@Autowired
	 private DataDefinitionService dataDefinitionService;
	
	
	@MessageMapping("/message/console")
    @SendTo("/broadcast/console")
	@Transactional
    public String sendNewAction() {

		String message = "";
		List<LogDBAction> logList = dataAccessService.getAllLogDBActionNotNotified();
		
		if(logList.size() == 0){
			message = "NO_RESULTS";
		}else{
			String separator = "";
			for(LogDBAction log : logList){
				message += separator + log.getActionDesc();
				separator = "|";
				
				//UPDATE STATE
				dataDefinitionService.updateLogDBAction(log, true);
			}
		}
        return message;
    }
	
}
