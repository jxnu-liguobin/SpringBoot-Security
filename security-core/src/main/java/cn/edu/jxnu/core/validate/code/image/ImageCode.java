package cn.edu.jxnu.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import cn.edu.jxnu.core.validate.code.ValidateCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 图片验证码实现
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class ImageCode extends ValidateCode {

	private BufferedImage image;

	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code, expireIn);
		this.image = image;
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code, expireTime);
		this.image = image;
	}

}
