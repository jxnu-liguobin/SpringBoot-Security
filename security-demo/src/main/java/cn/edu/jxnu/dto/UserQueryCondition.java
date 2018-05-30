package cn.edu.jxnu.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户查询条件
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Getter
@Setter
public class UserQueryCondition {

	private String username;

	// swagger属性名描述
	@ApiModelProperty(value = "用户年龄起始值")
	private int age;
	@ApiModelProperty(value = "用户年龄终止值")
	private int ageTo;

	private String xxx;

	@Override
	public String toString() {
		return "UserQueryCondition [username=" + username + ", age=" + age + ", ageTo=" + ageTo + ", xxx=" + xxx + "]";
	}

}
