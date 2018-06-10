package top.haha233.websocket.controller.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * websocket 处理
 *
 * @author ICE_DOG
 */
@Component(value = "webSocket")
public class WebsocketEndPoint extends TextWebSocketHandler{

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
		System.out.println("服务器收到信息为：" + message.getPayload());
		TextMessage returnMessage = new TextMessage("服务器收到信息为：" + message.getPayload());
		try {
			session.sendMessage(returnMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.handleBinaryMessage(session, message);
	}

}
