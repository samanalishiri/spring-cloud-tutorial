package com.saman.tutorial.springcloud.service.rest;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

@Component
public class HelloServiceClient implements CommandLineRunner {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private EurekaClient eurekaClient;

    @Override
    public void run(String... args) throws Exception {
        out.println("services : ");
        client.getServices().stream().forEach(out::println);
        out.println("---------------------------------------------");

        out.println("application : ");
        eurekaClient.getApplications()
                .getRegisteredApplications()
                .stream()
                .forEach(application -> out.println(application.getName()));
        out.println("---------------------------------------------");
    }
}
