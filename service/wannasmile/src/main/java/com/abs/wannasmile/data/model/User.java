package com.abs.wannasmile.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by phongbv on 5/25/17.
 */
@Document(collection = "User")
public class User {

    @Id
    private String id;

    private String userName;

    private Boolean admin;

    private String password;

    private Boolean haveNoti;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getHaveNoti() {
        return haveNoti;
    }

    public void setHaveNoti(Boolean haveNoti) {
        this.haveNoti = haveNoti;
    }
}
