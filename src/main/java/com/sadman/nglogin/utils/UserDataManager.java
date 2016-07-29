package com.sadman.nglogin.utils;

import com.sadman.nglogin.model.User;

/**
 * Manages {@code User} data
 *
 * @author Sadman
 * @since Jul 29, 2016
 */
public class UserDataManager {

    /**
     * Puts {@code User} in the {@code UserDB} map with user id as the key
     * 
     * @param   user the {@code User} that needs to be saved
     */
    public static void save(User user) {
        UserDB.getInstance().getUsers().put(user.getUserId(), user);
    }

    /**
     * Gets the {@code User} from the {@code UserDB} map
     * 
     * @param   userId the key to retrieve the corresponding {@code User}
     * @return  Retrieved {@code User} with the corresponding key
     */
    public static User load(String userId) {
        return UserDB.getInstance().getUsers().get(userId);
    }

    /**
     * Checks if {@code User} with the provided user id exists or not
     * 
     * @param   userId key to check the {@code UserDB} map
     * @return  {@code true} if map contains the user id as a key, {@code false} otherwise
     */
    public static boolean checkExistence(String userId) {
        return UserDB.getInstance().getUsers().containsKey(userId);
    }

}
