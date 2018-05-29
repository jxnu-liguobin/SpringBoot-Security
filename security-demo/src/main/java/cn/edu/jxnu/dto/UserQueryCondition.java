package cn.edu.jxnu.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户查询条件
 */
public class UserQueryCondition {

	private String username;

	@ApiModelProperty(value = "用户年龄起始值")
	private int age;
	@ApiModelProperty(value = "用户年龄终止值")
	private int ageTo;

	private String xxx;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

	@Override
	public String toString() {
		return "UserQueryCondition [username=" + username + ", age=" + age + ", ageTo=" + ageTo + ", xxx=" + xxx + "]";
	}

}
