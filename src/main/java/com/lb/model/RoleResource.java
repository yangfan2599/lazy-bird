package com.lb.model;

public class RoleResource extends RoleResourceKey {
    private Long creator;

    private Long createDate;

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