package com.saman.tutorial.springcloud.service.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestService {

    @RequestMapping(value = {"/", "service/hello"})
    public String hello(){
        return "Hello";
    }
}
