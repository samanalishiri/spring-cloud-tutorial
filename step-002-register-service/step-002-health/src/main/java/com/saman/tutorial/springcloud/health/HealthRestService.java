package com.saman.tutorial.springcloud.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestService {

    @RequestMapping(value = {"/"})
    public String hello(){
        return "Hello Health";
    }
}
