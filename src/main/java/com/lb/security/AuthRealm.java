package com.lb.security;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.lb.constant.Global;
import com.lb.constant.Message;
import com.lb.model.Login;
import com.lb.model.Resource;
import com.lb.service.LoginService;
import com.lb.service.ResourceService;
import com.lb.tool.Tools;

public class AuthRealm extends AuthorizingRealm {

	@javax.annotation.Resource
	private LoginService loginService;
	@javax.annotation.Resource
	private ResourceService resourceService;
	
	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) token;
		
		Login login = loginService.selectByUsername(usernamePasswordToken.getUsername());
		
		if( login == null ){
			throw new UnknownAccountException(Message.AUTH_ERROR_MSG);
		}
		
		if(!login.getEnable() || login.getFailTimes() > Global.LOGIN_FAIL_TIMES){  
            throw new LockedAccountException(Message.USR_LOCKED);  
        } 
		
		return new SimpleAuthenticationInfo(login, login.getPassword(), ByteSource.Util.bytes(login.getSalt()),this.getClass().getName());
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		Login login = (Login) principals.getPrimaryPrincipal();
		
		List<Resource> resources = resourceService.selectByUid(login.getId());

		if(Tools.isEmpty(resources)){
			return null;
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		for (Resource resource : resources) {
			info.addRole(resource.getRid().toString());
			info.addStringPermission(resource.getResource());
		}
		
		return info;
		
	}
	
	public static Long getUserKey(){
		Login login = (Login) SecurityUtils.getSubject().getPrincipal();
		return login.getId();
	}
	
}
