package com.lb.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthConfig.class);
	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		
		logger.debug("Shiro Configuration Filter Running!");
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
        Map<String,String> chain = new LinkedHashMap<String,String>();
        chain.put("/static/**", "anon");
        chain.put("/plugin/**", "anon");
        chain.put("/pages/**", "anon");
        chain.put("/logout", "logout");
        chain.put("/login", "anon");
        chain.put("/auth", "anon");
        chain.put("/**", "authc");
        
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(chain);
        
        return shiroFilterFactoryBean;
	}
	
	@Bean(name = "authRealm")
    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher credentialsMatcher){
		AuthRealm authRealm = new AuthRealm();
		authRealm.setCredentialsMatcher(credentialsMatcher);
        return authRealm;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        return securityManager;
    }
    
}
