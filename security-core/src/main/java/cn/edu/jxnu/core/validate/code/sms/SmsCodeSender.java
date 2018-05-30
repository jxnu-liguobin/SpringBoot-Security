package cn.edu.jxnu.core.validate.code.sms;

/**
 * 验证码发送接口定义
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
public interface SmsCodeSender {

	void send(String mobile, String code);

}
