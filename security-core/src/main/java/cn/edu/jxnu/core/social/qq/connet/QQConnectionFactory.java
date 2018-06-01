package cn.edu.jxnu.core.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import cn.edu.jxnu.core.social.qq.api.QQ;

/**
 * QQ的ConnectionFactory实现
 * 
 * 传入服务提供者和API适配器
 * 
 * @author 梦境迷离
 * @time 2018年6月1日
 * @version v1.0
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
