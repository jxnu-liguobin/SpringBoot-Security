package cn.edu.jxnu.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import cn.edu.jxnu.core.authentication.AbstractChannelSecurityConfig;
import cn.edu.jxnu.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import cn.edu.jxnu.core.properties.SecurityConstants;
import cn.edu.jxnu.core.properties.SecurityProperties;
import cn.edu.jxnu.core.validate.code.ValidateCodeSecurityConfig;

/**
 * 认证配置
 * 
 * @author 梦境迷离.
 * @time 2018年6月4日
 * @version v1.0
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;

	/**
	 * 将社交配置添加到过滤器链上
	 */
	@Autowired
	private SpringSocialConfigurer imoocSocialSecurityConfig;

	@Autowired
	private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

	@Autowired
	private InvalidSessionStrategy invalidSessionStrategy;
	
    /**
     * 退出成功处理器
     */
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {


        // 配置和用户名密码登录相关的配置
		applyPasswordAuthenticationConfig(http);
		// 设置验证码相关的配置
		http.apply(validateCodeSecurityConfig)
		.and()
		// 设置短信登录相关的配置
		.apply(smsCodeAuthenticationSecurityConfig)
		.and()
		// 社交登录相关配置
		.apply(imoocSocialSecurityConfig)
		.and()
		.rememberMe()
		.tokenRepository(persistentTokenRepository())
		.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
		// 指定获取UserDetails的类
		.userDetailsService(userDetailsService)
		.and()
		// Session相关配置
		.sessionManagement()
		// 设置当Session过期时的策略处理
		.invalidSessionStrategy(invalidSessionStrategy)
		// 设置最大的Session数量，即用户在后面登录产生的Session会把前面登录时的Session失效掉。
		.maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
		//true则阻止后来的登陆行为
		.maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
		// 配置这个，就可以针对后面用户登录踢掉前面用户，对被踢掉的用户做一个处理
		.expiredSessionStrategy(sessionInformationExpiredStrategy)
		.and()
		.and()
		// 退出登录相关的配置
		// 下面两个logoutSuccessUrl和logoutSuccessHandler是互斥的，配置一个后另一个就会失效
        // 配置退出 登录后跳转的URL
        // .logoutSuccessUrl("/logout.html")
		.logout()
		.logoutUrl("/signOut")
		.logoutSuccessHandler(logoutSuccessHandler)
		// 删除浏览器中Cookie
        .deleteCookies("JSESSIONID")
		.and()
		.authorizeRequests()
		//DEFAULT_UNAUTHENTICATION_URL不可再拦截，否则会循环重定向
		.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
						SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
						securityProperties.getBrowser().getLoginPage(),
						SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
						securityProperties.getBrowser().getSignUpUrl(),
						securityProperties.getBrowser().getSignOutUrl(),
						securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".json",
						securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html", "/user/regist")
		.permitAll().anyRequest().authenticated().and()
		// 关闭跨域防护伪造
		.csrf().disable();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 记住我
	 */
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		// tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}

}
