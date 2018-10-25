package org.webscoketserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
	SimpMessageSendingOperations simpMessageSendingOperations;
	
	@MessageMapping("/marco")
	public void  getMessage(String content){
		System.out.println("*******************************************************");
	    System.out.println("客户端："+content);
	    System.out.println("*******************************************************");
	}
	
	@RequestMapping("/send")
	public  String sentMessage(String  message){
		 simpMessageSendingOperations.convertAndSend("/app/marco",message);
	     return "I am a msg from SubscribeMapping('/macro')";
	}
	
	
	
}
