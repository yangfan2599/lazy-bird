package com.lb.model;

public class OrganRole extends OrganRoleKey {
	
	private static final long serialVersionUID = 1L;

	private Long createDate;

    private Long creator;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }
}