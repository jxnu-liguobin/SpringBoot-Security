package cn.edu.jxnu.browser.logout;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.edu.jxnu.browser.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定以退出登陆handler
 * 
 * 处理退出后的逻辑
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Slf4j
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

	private String signOutUrl;

	private ObjectMapper objectMapper = new ObjectMapper();

	public MyLogoutSuccessHandler(String signOutUrl) {
		this.signOutUrl = signOutUrl;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		// 主页localhost:8080/index.html，测试session返回json和页面两种方式
		log.info("退出成功");
		// 根据用户是否配置退出页面，来判断退出后进行跳转还是发送JSON
		if (StringUtils.isBlank(signOutUrl)) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
		} else {
			response.sendRedirect(signOutUrl);
		}
	}
}