package com.sadman.nglogin.service;

import com.sadman.nglogin.model.Response;
import com.sadman.nglogin.utils.UserDataManager;

/**
 * {@code User} data retriever
 *
 * @author Sadman
 * @since Jul 29, 2016
 */
public class UserDetailsRetriever {

    /**
     * Retrieves {@code User} details by userID
     *
     * @param userId user id of the {@code User} that is requested to be retrieved
     * @return {@code User} details
     */
    public Response getUserDetails(String userId) {
        if (UserDataManager.checkExistence(userId)) {
            return new Response(200, "User details successfully retrieved", UserDataManager.load(userId));
        }
        return new Response(101, "User doesn't exist!");
    }

}
