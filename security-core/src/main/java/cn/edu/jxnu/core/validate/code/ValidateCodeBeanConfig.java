package cn.edu.jxnu.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.edu.jxnu.core.properties.SecurityProperties;
import cn.edu.jxnu.core.validate.code.image.ImageCodeGenerator;
import cn.edu.jxnu.core.validate.code.sms.DefaultSmsCodeSender;
import cn.edu.jxnu.core.validate.code.sms.SmsCodeSender;

/**
 * 注册验证码功能所需bean
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;

	/**
	 * 注入图形验证码，需要系统配置信息
	 */
	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}

	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

}
