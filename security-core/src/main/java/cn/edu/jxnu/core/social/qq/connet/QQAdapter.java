package cn.edu.jxnu.core.social.qq.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import cn.edu.jxnu.core.social.qq.api.QQ;
import cn.edu.jxnu.core.social.qq.api.QQUserInfo;

/**
 * QQ的Adapter实现，适配API
 * 
 * 
 * @author 梦境迷离
 * @time 2018年6月1日
 * @version v1.0
 */
public class QQAdapter implements ApiAdapter<QQ> {

	/**
	 * 测试QQ是否是通的
	 */
	@Override
	public boolean test(QQ api) {
		return true;
	}

	/**
	 * 把ConnectionValues需要的数据设置进去
	 */
	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		// 拿到QQ的用户信息
		QQUserInfo userInfo = api.getUserInfo();
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getOpenId());
	}

	@Override
	public UserProfile fetchUserProfile(QQ api) {
		return null;
	}

	@Override
	public void updateStatus(QQ api, String message) {
	}

}
