package top.haha233.websocket.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.haha233.websocket.common.utils.Response;

import javax.servlet.http.HttpSession;

/**
 * 会话 controller
 *
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "/session", produces = "application/json;charset=utf-8")
@ResponseBody
public class SessionController {
	private static final Gson GSON = new Gson();

	/**
	 * 登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @param session  会话对象
	 * @return 响应值
	 * @throws Throwable 发生异常时抛出
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpSession session, String username, String password) throws Throwable {
		System.out.println(session);
		return GSON.toJson(new Response(0));
	}
}
