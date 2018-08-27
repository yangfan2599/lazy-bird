package com.lb.tool;

import java.util.Collection;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lb.constant.Global;
import com.lb.global.GlobalException;

public class Tools {

	/**
	 * 生成6位随机数字加字母
	 */
	public static String random() {
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		String meta;
		int value;
		for (int i = 0; i < 6; i++) {
			meta = random.nextInt(2) % 2 == 0 ? "char" : "num";
			if ("char".equalsIgnoreCase(meta)) {
				value = random.nextInt(2) % 2 == 0 ? 65 : 97;
				buffer.append((char) (random.nextInt(26) + value));
			} else if ("num".equalsIgnoreCase(meta)) {
				buffer.append(String.valueOf(random.nextInt(10)));
			}
		}
		return buffer.toString();
	}

	
	/**
	 * 判断是否为空
	 */
	public static boolean isEmpty(String arg){
		
		if(arg == null || "".equals(arg)){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为空
	 */
	public static boolean isEmpty(Collection<?> c){
		if(c == null || c.size() == 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 将对象转换成json
	 */
	public static String writeAsString(Object data) throws GlobalException {
		try {
			return new ObjectMapper().writeValueAsString(data);
		} catch (JsonProcessingException e) {
			throw new GlobalException(Global.StatusCode.FAIL.value,e.getMessage());
		}
	}
}
