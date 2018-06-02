package cn.edu.jxnu.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * 自定义ConnectionSignUp
 * 
 * ConnectionSignUp 不为空则将自动为QQ登陆的用户注册
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {

	@Override
	public String execute(Connection<?> connection) {
		// 根据社交【QQ】用户信息默认创建用户并返回用户唯一标识
		return connection.getDisplayName();
	}

}
