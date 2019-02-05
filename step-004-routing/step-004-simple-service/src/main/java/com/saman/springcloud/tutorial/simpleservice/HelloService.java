package com.saman.springcloud.tutorial.simpleservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {
 
	@Value("${server.port}")
	String port;

	@RequestMapping("step004/hello")
	public String hello() {
		return "Hello from a service running at port: " + port + "!";
	}
}