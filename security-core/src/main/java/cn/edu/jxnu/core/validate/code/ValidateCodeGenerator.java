package cn.edu.jxnu.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码创建接口
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);

}
