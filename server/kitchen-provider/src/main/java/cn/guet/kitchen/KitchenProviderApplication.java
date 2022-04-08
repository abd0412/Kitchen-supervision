package cn.guet.kitchen;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;


@EnableDiscoveryClient
@EnableSwagger2Doc
@SpringBootApplication
public class KitchenProviderApplication {
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    public static void main(String[] args) {
        SpringApplication.run(KitchenProviderApplication.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        return factory.createMultipartConfig();
    }

}
