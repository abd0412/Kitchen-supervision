package cn.gxhunter.tourism.zuulgateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
public class ResouceServerConfig {

    public static final String RESOURCE_ID = "tourism_api";

    /**
     * uaa资源服务配置，直接放行
     * 没有该配置会报错：
     * "error": "unauthorized",
     * "error_description": "Full authentication is required to access this resource"
     */


    @Configuration
    @EnableResourceServer
    public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            //先配置特例的security-uaa/，最后配置全局的/**。否则先执行全局规则，后面的配置就不执行了。
            http.authorizeRequests()
                    .antMatchers("/security-uaa/**").permitAll()
                    //swagger相关放行
                    .antMatchers("/**/swagger-ui.html").permitAll()
                    .antMatchers("/**/swagger-resources/**").permitAll()
                    .antMatchers("/**/images/**").permitAll()
                    .antMatchers("/**/webjars/**").permitAll()
                    .antMatchers("/**/v2/api-docs").permitAll()
                    .antMatchers("/**/configuration/ui").permitAll()
                    .antMatchers("/**/configuration/security").permitAll()
                    //系统管理的资源服务,开发阶段暂时先放行
                    .antMatchers("/system/**").permitAll()
                    .antMatchers("/basicinfo/**").permitAll()
                    .antMatchers("/file/**").permitAll()
                    .antMatchers("/welcome/**").permitAll()
                    .antMatchers("/public/**").permitAll()
                    .antMatchers("/wc/**").permitAll()
                    .antMatchers("/lb/**").permitAll()
                    .antMatchers("/filehelper/**").permitAll()
                    .antMatchers("/wwc/**").permitAll()
                    .antMatchers("/llb/**").permitAll()
                    //其他需验证
                    .antMatchers("/**").authenticated();
        }
    }
}
