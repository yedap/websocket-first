package org.webscoketserver.config.websocketcnf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.webscoketserver.config.websocketcnf.interceptors.ClientInInterceptor;
import org.webscoketserver.config.websocketcnf.interceptors.ClientOutInterceptor;
import org.webscoketserver.config.websocketcnf.interceptors.CustomSubProtocolWebSocketHandler;
import org.webscoketserver.config.websocketcnf.interceptors.SessionInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends WebSocketMessageBrokerConfigurationSupport implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableStompBrokerRelay("/exchange", "/topic", "/queue", "/amq/queue").setRelayHost("192.168.2.2")
				.setClientLogin("rabbitmq").setClientPasscode("rabbitmq").setSystemLogin("rabbitmq")
				.setSystemPasscode("rabbitmq").setSystemHeartbeatReceiveInterval(120000);
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/sockjs").setAllowedOrigins("*").withSockJS().setWebSocketEnabled(true)
				.setInterceptors(new SessionInterceptor()).setHeartbeatTime(120000);
	}

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
		// TODO Auto-generated method stub
		WebSocketMessageBrokerConfigurer.super.configureWebSocketTransport(registry);
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		// stomp 客户端 输入消息时拦截
		registration.interceptors(new ClientInInterceptor());
		WebSocketMessageBrokerConfigurer.super.configureClientInboundChannel(registration);
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
		registration.interceptors(new ClientOutInterceptor());
		WebSocketMessageBrokerConfigurer.super.configureClientOutboundChannel(registration);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		WebSocketMessageBrokerConfigurer.super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		WebSocketMessageBrokerConfigurer.super.addReturnValueHandlers(returnValueHandlers);
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		return WebSocketMessageBrokerConfigurer.super.configureMessageConverters(messageConverters);
	}

	@Bean
	public WebSocketHandler subProtocolWebSocketHandler() {
		return new CustomSubProtocolWebSocketHandler(clientInboundChannel(), clientOutboundChannel());
	}

}
