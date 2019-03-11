package com.saman.springcloud.tutorial.zuul;

import com.saman.springcloud.tutorial.zuul.filter.ErrorFilter;
import com.saman.springcloud.tutorial.zuul.filter.PostFilter;
import com.saman.springcloud.tutorial.zuul.filter.PreFilter;
import com.saman.springcloud.tutorial.zuul.filter.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}