package com.lb.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.lb.constant.Message;

public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message= Message.LOGIN_NOT_NULL)
    private String username;

	@NotNull(message= Message.LOGIN_NOT_NULL)
    private String password;

    private String salt;

    private Boolean enable;

    private Integer failTimes;

    private Long createDate;

    private Long modifyDate;

    private Long creator;

    private Long modifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
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
}