package org.webscoketserver.config.websocketcnf.interceptors;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * @author yemeng
 * stomp 客户端连接 输入消息时拦截
 */
public class ClientInInterceptor implements ChannelInterceptor{

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		System.out.println("接收客户端消息：" + message.getHeaders());
		return ChannelInterceptor.super.preSend(message, channel);
	}

	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		// TODO Auto-generated method stub
		ChannelInterceptor.super.postSend(message, channel, sent);
	}

	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
		// TODO Auto-generated method stub
		ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
	}

	@Override
	public boolean preReceive(MessageChannel channel) {
		// TODO Auto-generated method stub
		return ChannelInterceptor.super.preReceive(channel);
	}

	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		// TODO Auto-generated method stub
		return ChannelInterceptor.super.postReceive(message, channel);
	}

	@Override
	public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
		// TODO Auto-generated method stub
		ChannelInterceptor.super.afterReceiveCompletion(message, channel, ex);
	}

	
	
}
