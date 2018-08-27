package com.lb.model;

import java.io.Serializable;

public class OrganRoleKey  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long oid;

    private Long rid;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}