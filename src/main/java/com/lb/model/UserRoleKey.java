package com.lb.model;

import java.io.Serializable;

public class UserRoleKey implements Cloneable,Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long rid;

    private Long uid;
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}