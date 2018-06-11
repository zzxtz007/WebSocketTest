package top.haha233.websocket.controller.webtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * websocket 配置文件
 *
 * @author ICE_DOG
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatMessageHandler(), "/ws/test")
				.addInterceptors(new ChatHandshakeInterceptor());
		registry.addHandler(chatMessageHandler(), "/ws/sockjs/test")
				.addInterceptors(new ChatHandshakeInterceptor()).withSockJS();
	}

	@Bean
	public TextWebSocketHandler chatMessageHandler() {
		return new ChatMessageHandler();
	}
}
