package org.webscoketserver.config.websocketcnf.interceptors;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class ClientOutInterceptor implements ChannelInterceptor{

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		return ChannelInterceptor.super.preSend(message, channel);
	}
	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		ChannelInterceptor.super.postSend(message, channel, sent);
	}

	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
		ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
	}

	@Override
	public boolean preReceive(MessageChannel channel) {
		return ChannelInterceptor.super.preReceive(channel);
	}

	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		return ChannelInterceptor.super.postReceive(message, channel);
	}

	@Override
	public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
		// TODO Auto-generated method stub
		ChannelInterceptor.super.afterReceiveCompletion(message, channel, ex);
	}
	
}
