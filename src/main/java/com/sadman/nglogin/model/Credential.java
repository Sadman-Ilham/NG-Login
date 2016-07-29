package com.sadman.nglogin.model;

/**
 * @author Sadman
 * @since Jul 28, 2016
 */
public class Credential {
    String userId;
    String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
