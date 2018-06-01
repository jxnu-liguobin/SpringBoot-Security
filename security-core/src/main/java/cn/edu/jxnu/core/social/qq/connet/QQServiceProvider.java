package cn.edu.jxnu.core.social.qq.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import cn.edu.jxnu.core.social.qq.api.QQ;
import cn.edu.jxnu.core.social.qq.api.QQImpl;

/**
 * QQ的Provider实现
 * 
 * 不能使用Component注解，因为这样是单例的
 * 
 * @author 梦境迷离
 * @time 2018年6月1日
 * @version v1.0
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

	private String appId;

	// 第三方应用将用户导向服务器的时候使用这个url
	private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

	// 申请令牌的时候使用这个url
	private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

	public QQServiceProvider(String appId, String appSecret) {
		// 使用自定义的OAuth2Template
		super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}

	@Override
	public QQ getApi(String accessToken) {
		return new QQImpl(accessToken, appId);
	}

}
