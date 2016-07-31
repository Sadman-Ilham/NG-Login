package com.sadman.nglogin.service;

import com.sadman.nglogin.enums.ResponseCode;
import com.sadman.nglogin.model.Credential;
import com.sadman.nglogin.model.Response;
import com.sadman.nglogin.model.ResponseData;
import com.sadman.nglogin.model.User;
import com.sadman.nglogin.utils.UserDataManager;

/**
 * It verifies a {@code User}
 *
 * @author Sadman
 * @since Jul 28, 2016
 */
public class UserAuthenticator {

    /**
     * Checks if the {@code Credential} is verified or not
     *
     * @param credential
     * @return {@code Response} with 200 if {@code Credential} is verified,
     * {@code Response} with 401 otherwise.
     */
    public Response authenticate(Credential credential) {
        if (credential.getUserId() != null && credential.getPassword() != null
                && UserDataManager.checkExistence(credential.getUserId())) {
            User user = UserDataManager.load(credential.getUserId());
            if (credential.getPassword().equals(user.getPassword())) {
                return new ResponseData(ResponseCode.OPERATION_SUCCESSFUL.getCode(), "Successful login", credential);
            }
        }
        return new Response(ResponseCode.AUTHENTICATION_FAILED.getCode(), "Invalid username or password");
    }

    /**
     * Checks if {@code User} with the provided user id exists or not.
     * If exists then it checks if the provided password is same as the password of the retrieved user
     *
     * @param userId
     * @return {@code true} if user is already authenticated, {@code false} otherwise
     */
    public boolean isAuthenticated(String userId, String password) {
        if (UserDataManager.checkExistence(userId)) {
            User user = UserDataManager.load(userId);
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generate a bad response when authentication is failed
     *
     * @return Authentication failed {@code Response}
     */
    public Response getFailedAuthResponse() {
        return new Response(ResponseCode.AUTHENTICATION_FAILED.getCode(), "Authenticated failed");
    }

}
