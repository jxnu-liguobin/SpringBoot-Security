package cn.edu.jxnu.browser.support;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 梦境迷离.
 * @time 2018年6月1日
 * @version v1.0
 */
@Setter
@Getter
public class SimpleResponse {

	public SimpleResponse(Object content) {
		this.content = content;
	}

	private Object content;

}
