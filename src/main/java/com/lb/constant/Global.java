package com.lb.constant;

public class Global {
	
	//登录失败次数
	public static final Integer LOGIN_FAIL_TIMES = 5;
	//加密次数
	public static final Integer HASH_ITERATIONS = 2;
	//状态码
	public static enum StatusCode{
		SUCCESS(200),
		FAIL(500),
		FAIL_SERVER(406);
        public Integer value;
        private StatusCode(Integer value){this.value=value;}
    }
	//资源类型
	public static enum ResourceType{
        NAV(1),
        BTN(2);
        public Integer value;
        private ResourceType(Integer value){this.value=value;}
    }
	//字典类型
	public static enum DictionaryType{
		COURSE(1),
		NOTICE(2);
        public Integer value;
        private DictionaryType(Integer value){this.value=value;}
    }
	
}
