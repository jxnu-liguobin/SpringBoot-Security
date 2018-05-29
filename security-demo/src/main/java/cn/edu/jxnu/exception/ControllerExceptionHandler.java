package cn.edu.jxnu.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理建言
 * 
 * 将UserNotExistException进行拦截保证，再次以500错误返回
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * 自定义UserNotExistException的异常处理器
	 * 
	 * @param ex
	 * @return 返回自定义的处理
	 *
	 */
	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handleUserNotExistException(UserNotExistException ex) {
		Map<String, Object> result = new HashMap<>();
		result.put("id", ex.getId());
		result.put("message", ex.getMessage());
		return result;
	}

}
