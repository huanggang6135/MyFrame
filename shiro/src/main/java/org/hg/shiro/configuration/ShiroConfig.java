package org.hg.shiro.configuration;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.hg.shiro.configuration.session.ShiroSessionListener;
import org.hg.shiro.realm.CustomRealm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Author hg
 * @Date 2019/4/1 19:41
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    @Value("${logUrl:/toLogin}")
    private String logUrl;
    @Value("${unauthorizedUrl:/unauthorized}")
    private String unauthorizedUrl;
    @Value("${successUrl:/}")
    private String successUrl;
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        /*** ============ 未登录  ================= **/
        factoryBean.setLoginUrl(logUrl);
        /*** ============ 未授权  ================= **/
        factoryBean.setUnauthorizedUrl(unauthorizedUrl);
        /*** ============ 验证成功  ================= **/
        factoryBean.setSuccessUrl(successUrl);
        HashMap<String, String> filterChainDefinitionMap = new HashMap<>(16);
        /*** ============ 游客权限  ================= **/
        filterChainDefinitionMap.put("/guest/**", "anon");
        /*** ============ 用户权限  ================= **/
        filterChainDefinitionMap.put("/user/**", "roles[user,admin]");
        /*** ============ 管理员权限  ================= **/
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        /*** ============ 开放登录接口  ================= **/
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/toLogin", "anon");
        /*** ============ 开放swagger2访问权限  ================= **/
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        /*** ============ 其余地址全部权限验证  ================= **/
        filterChainDefinitionMap.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return factoryBean;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        /*** ============ 设置realm  ================= **/
        securityManager.setRealm(customRealm());
        return securityManager;
    }
    @Bean
    public Realm customRealm() {
        return new CustomRealm();
    }
    @Bean
    public ShiroSessionListener sessionListener(){
        return new ShiroSessionListener();
    }
    @Bean
    public SessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }
}
