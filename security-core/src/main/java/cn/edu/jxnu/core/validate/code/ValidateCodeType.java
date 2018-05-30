package cn.edu.jxnu.core.validate.code;

import cn.edu.jxnu.core.properties.SecurityConstants;

/**
 * 校验码类型枚举
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
public enum ValidateCodeType {

	/**
	 * 短信验证码
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	},
	/**
	 * 图片验证码
	 */
	IMAGE {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
		}
	};

	/**
	 * 校验时从请求中获取的参数的名字
	 */
	public abstract String getParamNameOnValidate();

}
