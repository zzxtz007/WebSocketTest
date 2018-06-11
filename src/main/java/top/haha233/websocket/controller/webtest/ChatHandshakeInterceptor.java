package top.haha233.websocket.controller.webtest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import top.haha233.websocket.common.utils.AppContextUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ICE_DOG
 */
public class ChatHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		System.out.println("握手之前");
		// 使用 AppContextUtils 工具获取 session
		HttpSession session = AppContextUtils.getSession();
		System.out.println(session);
		// 使用userName区分WebSocketHandler，以便定向发送消息
		String userName = (String) session.getAttribute(Constants.SESSION_USERNAME);
		if (userName == null) {
			userName = "default-system";
		}
		attributes.put(Constants.WEBSOCKET_USERNAME, userName);
		return super.beforeHandshake(request, response, wsHandler, attributes);

	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler wsHandler, Exception ex) {
		System.out.println("握手之后");
		super.afterHandshake(request, response, wsHandler, ex);
	}
}

