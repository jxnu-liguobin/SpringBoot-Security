package cn.edu.jxnu.web.timer;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间拦截器
 * 
 * 实现拦截Restful API的第二种方法
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {

	/**
	 * 这种方法可以获取的控制器的请求方法信息
	 * 
	 * 注意，拦截器此时并不知道User对象，request中的的对象转化为User对象这个还没有开始 即request携带的数据
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle");

		log.info(((HandlerMethod) handler).getBean().getClass().getName());
		log.info(((HandlerMethod) handler).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
		Long start = (Long) request.getAttribute("startTime");
		log.info("time interceptor 耗时:" + (new Date().getTime() - start));

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		log.info("time interceptor 耗时:" + (new Date().getTime() - start));
		log.info("ex is " + ex);

	}

}
