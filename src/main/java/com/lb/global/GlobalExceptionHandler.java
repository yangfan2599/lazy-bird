package com.lb.global;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lb.constant.Global;
import com.lb.constant.Message;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	
    	Result result = null;
    	if(e instanceof GlobalException) {
    		GlobalException g = (GlobalException)e;
        	result = new Result(g.getCode(),g.getMessage());
    	} else if(e instanceof UnknownAccountException) {
    		result = Result.fail(Global.StatusCode.FAIL.value, Message.AUTH_ERROR_MSG);
    	} else if(e instanceof LockedAccountException) {
    		result = Result.fail(Global.StatusCode.FAIL.value, Message.USR_LOCKED);
    	} else if(e instanceof IncorrectCredentialsException) {
    		result = Result.fail(Global.StatusCode.FAIL.value, Message.AUTH_ERROR_MSG);
    	} else {
    		result = Result.fail(Global.StatusCode.FAIL_SERVER.value, Message.GLOBAL_MSG);
    	}
    	logger.error("Lazy-Bird Error:",e);
    	return result;
    	
    }
    
}
