package com.lb.model;

import javax.validation.constraints.NotNull;

import com.lb.constant.Message;

public class User extends Login {
	
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = Message.NAME_NOT_NULL)
    private String realname;

	@NotNull(message = Message.BIRTH_NOT_NULL)
    private Long birthday;

	@NotNull(message = Message.PHONE_NOT_NULL)
    private String phone;

    private String email;

    private String identityCard;

    private Long creator;

    private Long modifier;

    private Long createDate;

    private Long modifyDate;

    private String values;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
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

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }
}