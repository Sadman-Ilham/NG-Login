package com.sadman.nglogin.utils;

import com.sadman.nglogin.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Database for {@code User}
 *
 * @author Sadman
 * @since Jul 29, 2016
 */
public class UserDB {
    private Map<String, User> users = new HashMap<>();

    private static UserDB instance = new UserDB();

    public static UserDB getInstance() {
        return instance;
    }

    private UserDB() {}

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
