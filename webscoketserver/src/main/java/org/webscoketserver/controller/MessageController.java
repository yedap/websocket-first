package org.webscoketserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webscoketserver.model.Message;

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
	public  Message sentMessage(String  message){
		 simpMessageSendingOperations.convertAndSend("/queue/132123122",message);
	     Message msg =  new Message();
	     msg.setContent("helloword");
	     return msg;
	}
	
	@RequestMapping("/sendStr")
	public  String sentMessageStr(String  message){
		return "helloword";
	}
	
	
	
}
