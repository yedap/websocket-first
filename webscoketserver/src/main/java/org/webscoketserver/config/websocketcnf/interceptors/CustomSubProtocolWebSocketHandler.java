package org.webscoketserver.config.websocketcnf.interceptors;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;
import org.webscoketserver.config.websocketcnf.container.WebSocketSessionContainer;

public class CustomSubProtocolWebSocketHandler extends SubProtocolWebSocketHandler{

	
	
	@Autowired
	private WebSocketSessionContainer  webSocketSessionContainer;;
	
	public CustomSubProtocolWebSocketHandler(MessageChannel clientInboundChannel,
			SubscribableChannel clientOutboundChannel) {
		super(clientInboundChannel, clientOutboundChannel);
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		List<String> os = session.getHandshakeHeaders().get("cookie");
		for (String string : os) {
			  //JSESSIONID=DA60D23BC0A5928F38BA8E5F11FFC21C
		      String pattern = "(JSESSIONID=)(.{32})";
		      // 创建 Pattern 对象
		      Pattern r = Pattern.compile(pattern);
		      // 现在创建 matcher 对象
		      Matcher m = r.matcher(string);
		      if (m.find( )) {
		         System.out.println("Found value: " + m.group(0));
		         System.out.println("Found value: " + m.group(1)); 
		         System.out.println("Found value: " + m.group(2)); 
		         String id =m.group(2);
		         if(StringUtils.isNotBlank(id)){
		        	 webSocketSessionContainer.registere(id, session);
		         }
		      } else {
		         System.out.println("NO MATCH");
		      }
		}
		super.afterConnectionEstablished(session);
	}
	
}
