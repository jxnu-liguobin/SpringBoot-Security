package cn.edu.jxnu.core.social.qq.connet;

import java.nio.charset.Charset;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义的QQ的OAuth2Template实现
 * 
 * 
 * @author 梦境迷离
 * @time 2018年6月1日
 * @version v1.0
 */
@Slf4j
public class QQOAuth2Template extends OAuth2Template {

	public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
		// 发请求的时候才会带上client_id,client_secret
		setUseParametersForClientAuthentication(true);
	}

	/**
	 * 重新post方法
	 */
	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		// 发送post请求，需要响应类型，string
		String responseStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
		log.info("获取accessToke的响应：" + responseStr);
		String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(responseStr, "&");
		// 把等号后面的数据拿出来
		String accessToken = StringUtils.substringAfterLast(items[0], "=");
		Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));
		String refreshToken = StringUtils.substringAfterLast(items[2], "=");
		return new AccessGrant(accessToken, null, refreshToken, expiresIn);
	}

	/**
	 * 解决content-type问题
	 */
	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = super.createRestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate;
	}

}
