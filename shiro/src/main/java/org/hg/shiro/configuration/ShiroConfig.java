package org.hg.shiro.configuration;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author hg
 * @Date 2019/4/1 19:41
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        return null;
    }
}
