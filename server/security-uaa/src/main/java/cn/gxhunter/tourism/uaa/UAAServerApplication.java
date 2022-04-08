package cn.gxhunter.tourism.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户登录与授权服务（User Account and Authentication）
 *
 * @author:lujinlong
 * @created:2020-01-31 17:17
 **/
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
//@EnableFeignClients(basePackages = {"cn.gxhunter.ams.uaa"})
public class UAAServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UAAServerApplication.class, args);
    }


}
