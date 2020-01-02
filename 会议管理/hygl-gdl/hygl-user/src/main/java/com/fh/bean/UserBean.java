package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fh.utiles.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName(value = "t_user")
public class UserBean extends PageBean {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "userName")
    private String userName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "errorCount")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer errorCount = 0;

    @TableField(value = "loginCount")
    private Integer loginCount;

    @TableField(value = "errorTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date errorTime;

    @TableField(value = "loginTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}