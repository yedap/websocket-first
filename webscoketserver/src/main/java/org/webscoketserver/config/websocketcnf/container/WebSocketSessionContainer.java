package org.webscoketserver.config.websocketcnf.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;


@Configuration
public class WebSocketSessionContainer {

	
	private final static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>(200);
	
	public void registere(String sessionId  ,WebSocketSession session) {
		sessionMap.put(sessionId, session);
	}
	
}
