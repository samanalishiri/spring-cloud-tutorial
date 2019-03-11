package com.saman.springcloud.tutorial.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloRestService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showFirstService() {

        String serviceId = "hello-service";

        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

        if (instances == null || instances.isEmpty()) {
            return "No instances for service: " + serviceId;
        }

        StringBuilder htmlBuilder = new StringBuilder("<h2>Instances for Service Id: " + serviceId + "</h2>");

        instances.stream()
                .forEach(instance -> htmlBuilder.append("<p>Instance :" + instance.getUri() + "</p>"));

        htmlBuilder.append("<br><h2>Call service: " + serviceId + "</h2>");

        try {
            ServiceInstance service = loadBalancer.choose(serviceId);
            String url = "https://" + service.getHost() + ":" + service.getPort() + "/service/hello";
            String result = restTemplate.getForObject(url, String.class);

            htmlBuilder.append("<p>Load Balancer choose: " + service.getUri() + "</p>")
                    .append("<p>Make a Call: " + url + "</p>")
                    .append("<p>Result: " + result + "</p>");

        } catch (IllegalStateException e) {
            htmlBuilder.append("<p>loadBalancer.choose ERROR: " + e.getMessage() + "</p>");
        } catch (Exception e) {
            htmlBuilder.append("<p>Other ERROR: " + e.getMessage() + "</p>");
        }
        return htmlBuilder.toString();
    }

}