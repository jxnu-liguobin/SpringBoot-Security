package cn.edu.jxnu.core.validate.code.image;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import cn.edu.jxnu.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * 图片验证码处理器实现
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

	/**
	 * 发送图形验证码，将其写到响应中
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}

}
