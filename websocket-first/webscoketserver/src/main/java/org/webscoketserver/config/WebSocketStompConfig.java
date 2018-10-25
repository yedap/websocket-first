package org.webscoketserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
	/*	config.enableStompBrokerRelay("/exchange", "/topic", "/queue", "/amq/queue").setRelayHost("192.168.2.2")
				.setClientLogin("rabbitmq").setClientPasscode("rabbitmq")
				.setSystemHeartbeatSendInterval(5000).setSystemHeartbeatReceiveInterval(4000);*/
		config.setApplicationDestinationPrefixes("/app");
	}
	
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/sockjs").setAllowedOrigins("*").withSockJS().setWebSocketEnabled(true);
	}
	
/*	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
*/
}
