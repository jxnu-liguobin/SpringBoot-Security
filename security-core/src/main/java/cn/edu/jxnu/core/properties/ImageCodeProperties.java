package cn.edu.jxnu.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片验证码参数配置，可重用设计
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Getter
@Setter
public class ImageCodeProperties extends SmsCodeProperties {

	public ImageCodeProperties() {
		setLength(4);
	}

	private int width = 67;
	private int height = 23;

}
