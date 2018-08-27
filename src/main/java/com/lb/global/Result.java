package com.lb.global;

import java.io.Serializable;
import com.lb.constant.Global;
import com.lb.constant.Message;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int code;
	
	private String msg;
	
	private Object data;
	
	public Result(){}
	
	public Result(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Result(int code,String msg,Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public static Result success() {
		return new Result(Global.StatusCode.SUCCESS.value,Message.SUCCESS);
	}
	
	public static Result success(Object data) {
		return new Result(Global.StatusCode.SUCCESS.value,Message.SUCCESS,data);
	}
	
	public static Result fail(int code,String msg) {
		return new Result(Global.StatusCode.FAIL.value,msg);
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
