package org.webscoketserver.config.websocketcnf.interceptors;

import java.util.List;

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
		os.get(0);
		System.out.println(session.getAttributes().toString());
		webSocketSessionContainer.registere(session.getId(), session);
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
	}
	
}
