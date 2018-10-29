package org.webscoketserver.config.websocketcnf.interceptors;

import java.util.Set;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ChannelInterceptor;

public class ClientChannelInterceptor implements ChannelInterceptor {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		// TODO Auto-generated method stub
		MessageHeaders heades = message.getHeaders();
		Set<String> set =  heades.keySet();
		for (String string : set) {
			System.out.println("key:"+string+"->"+heades.get(string));
		}
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
