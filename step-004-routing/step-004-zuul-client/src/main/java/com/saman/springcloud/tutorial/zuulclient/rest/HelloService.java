package com.saman.springcloud.tutorial.zuulclient.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

    @RequestMapping("step004/hello")
    public String hello(){
        return "Hello";
    }
}
