package com.lb.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.lb.constant.Message;

public class Organ  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;

    @NotNull(message = Message.CODE_NOT_NULL)
    private String code;
    @NotNull(message = Message.NAME_NOT_NULL)
    private String name;

    private Long pid;
    
    private String parent;
    
    private String remark;

    private Long creator;

    private Long createDate;

    private Long modifier;

    private Long modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
    public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }
}