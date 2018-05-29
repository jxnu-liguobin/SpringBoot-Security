package cn.edu.jxnu.web.timer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现拦截Restful API的第一种方法
 * 
 * 时间过滤器
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
// @Component 模拟第三方过滤器，没有spring注解
@Slf4j
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		log.info("time filter destroy");
	}

	/**
	 * 这种方法只能拿到HTTP请求，不知道请求控制器是谁
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("time filter start");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		log.info("time filter 耗时:" + (new Date().getTime() - start));
		log.info("time filter finish");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("time filter init");
	}

}
