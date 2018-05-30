package cn.edu.jxnu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.edu.jxnu.web.timer.TimeFilter;
import cn.edu.jxnu.web.timer.TimeInterceptor;

/**
 * 自定义MVC配置
 * 
 * 用于注册第三方的过滤器
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	// 拦截器注入，不实用
	@SuppressWarnings("unused")
	@Autowired
	private TimeInterceptor timeInterceptor;

	// 拦截器，关闭
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(timeInterceptor);
	}

	// 过滤器，关闭
	// @Bean
	public FilterRegistrationBean timeFilter() {

		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		return registrationBean;

	}

	// 异步支持
	// @Override
	// public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	// super.configureAsyncSupport(configurer);
	// }

}
