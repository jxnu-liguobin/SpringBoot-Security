package cn.edu.jxnu.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.jxnu.service.HelloService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

	@Override
	public String greeting(String name) {
		log.info("greeting");
		return "hello " + name;
	}

}
