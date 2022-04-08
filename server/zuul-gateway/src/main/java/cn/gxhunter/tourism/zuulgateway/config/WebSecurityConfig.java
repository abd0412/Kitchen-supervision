package cn.gxhunter.tourism.zuulgateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //默认情况下所有请求需要登录校验。可在ResouceServerConfig中单独配置放行或其他安全策略。ResouceServerConfig中的配置优先级高。
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .and().csrf().disable();

        // 替换成以下配置，则所有请求放行
        //        http
        //                .authorizeRequests()
        //                .antMatchers("/**").permitAll()
        //                .and().csrf().disable();

    }
}
