package com.lb.global;

import com.lb.constant.Global;

public class GlobalException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	public GlobalException(String message) {
		super(message);
        this.code = Global.StatusCode.FAIL.value;
    }
	
	public GlobalException(Integer code, String message) {
        super(message);
        this.code = code;
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	
}
