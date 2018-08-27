package com.lb.security;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Component;

import com.lb.constant.Global;
import com.lb.service.LoginService;

@Component
public class CredentialsMatcher extends SimpleCredentialsMatcher{

	@Resource
	private LoginService loginService;
	
	@Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String inputPassword = String.valueOf(utoken.getPassword());
        String storePassword = (String) info.getCredentials();
        return this.equals(inputPassword, storePassword);
    }
	
	public static String encrypt(String password,String salt){
		return new Md5Hash(password, salt, Global.HASH_ITERATIONS).toString();
	}
	
}
