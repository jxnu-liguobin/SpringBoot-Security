package cn.edu.jxnu.core.validate.code.sms;

/**
 * 短信验证码发送实现
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机" + mobile + "发送短信验证码" + code);
	}

}
