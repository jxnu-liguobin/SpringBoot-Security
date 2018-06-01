package cn.edu.jxnu.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 自定义的SpringSocialConfigurer配置
 * 
 * @author 梦境迷离.
 * @time 2018年6月1日
 * @version v1.0
 */
public class ImoocSpringSocialConfigurer extends SpringSocialConfigurer {

	private String filterProcessesUrl;

	public ImoocSpringSocialConfigurer(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> T postProcess(T object) {
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		filter.setFilterProcessesUrl(filterProcessesUrl);
		return (T) filter;
	}

}
