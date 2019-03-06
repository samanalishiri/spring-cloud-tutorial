package com.saman.tutorial.springcloud.hystrix;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
        URL resource = HystrixApplication.class.getResource("/client.jks");

        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
        System.setProperty("javax.net.ssl.keyStore", resource.getPath());
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
        System.setProperty("javax.net.ssl.keyPassword", "123456");
        System.setProperty("javax.net.ssl.trustStore", resource.getPath());
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
        builder.withClientName("client-app");
        builder.withSystemSSLConfiguration();
        builder.withMaxTotalConnections(10);
        builder.withMaxConnectionsPerHost(10);
        args.setEurekaJerseyClient(builder.build());
        return args;
    }
}
