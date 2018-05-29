package cn.edu.jxnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring　Security";
	}

}
