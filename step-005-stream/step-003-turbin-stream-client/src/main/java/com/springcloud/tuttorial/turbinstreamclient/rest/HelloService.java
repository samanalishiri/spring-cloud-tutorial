package com.springcloud.tuttorial.turbinstreamclient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloService {

    @RequestMapping("/")
    public String testFallBack() {
        throw new RuntimeException();
    }

    public String fallBack() {
        return "Call fallBack!";
    }

}
