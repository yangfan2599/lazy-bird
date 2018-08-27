package com.lb.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.lb.constant.Message;

public class Role {
	
    private Long id;

    @NotNull(message = Message.NAME_NOT_NULL)
    private String name;

    private Boolean enable;
    
    private Integer priority;

    private String remark;
    
    private String values;
    
    private List<Organ> organs;

    private Long creator;

    private Long modifier;

    private Long createDate;

    private Long modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public List<Organ> getOrgans() {
		return organs;
	}

	public void setOrgans(List<Organ> organs) {
		this.organs = organs;
	}

	public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

}