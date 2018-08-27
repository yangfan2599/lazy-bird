package com.lb.model;

public class UserRole extends UserRoleKey {
	
	private static final long serialVersionUID = 1L;

	private Long creator;

    private Long createDate;

    @Override
    protected Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
    
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}