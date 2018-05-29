package cn.edu.jxnu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.fasterxml.jackson.annotation.JsonView;

import cn.edu.jxnu.dto.User;
import cn.edu.jxnu.dto.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户控制器
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	@PostMapping("/regist")
	public void regist(User user, HttpServletRequest request) {

		// 不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
		String userId = user.getUsername();
		providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
	}

	@GetMapping("/me")
	public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
		return user;
	}

	@PostMapping
	@ApiOperation(value = "创建用户")
	public User create(@Valid @RequestBody User user) {

		log.info(user.getId());
		log.info(user.getUsername());
		log.info(user.getPassword());
		log.info("{}", user.getBirthday());

		user.setId("1");
		return user;
	}

	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {

		log.info("{}", user.getId());
		log.info("{}", user.getUsername());
		log.info("{}", user.getPassword());
		log.info("{}", user.getBirthday());

		user.setId("1");
		return user;
	}

	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id) {
		log.info(id);
	}

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	@ApiOperation(value = "用户查询服务")
	public List<User> query(UserQueryCondition condition,
			@PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {

		log.info(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

		log.info("{}", pageable.getPageSize());
		log.info("{}", pageable.getPageNumber());
		log.info("{}", pageable.getSort());

		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}

	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@ApiParam("用户id") @PathVariable String id) {
		// throw new RuntimeException("user not exist");
		log.info("进入getInfo服务");
		User user = new User();
		user.setUsername("tom");
		return user;
	}

}
