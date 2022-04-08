package cn.gxhunter.tourism.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * api路由网关主启动类
 *
 * @author:lujinlong
 * @created:2019-12-23 17:51
 **/
@SpringBootApplication
//加上网关注解
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
