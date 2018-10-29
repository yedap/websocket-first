package org.webscoketserver.config.websocketcnf.interceptors;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class SessionInterceptor implements HandshakeInterceptor {

	private Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	
	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		
		ServletServerHttpRequest serverRequest = (ServletServerHttpRequest)request;
//		wsHandler.afterConnectionEstablished(session);
		logger.info("连接时的属性："+attributes.toString());
		
		HttpSession session = serverRequest.getServletRequest().getSession();
		
//		logger.info(wsHandler.afterConnectionEstablished(session));
		return true;
	}
	
	

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
	}

}
