package com.sadman.nglogin.service;

import com.sadman.nglogin.enums.ResponseCode;
import com.sadman.nglogin.model.Credential;
import com.sadman.nglogin.model.Response;
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
     * @param   credential
     * @return  {@code Response} with 200 if {@code Credential} is verified,
     *          {@code Response} with 401 otherwise.
     */
    public Response authenticate(Credential credential) {
        if (UserDataManager.checkExistence(credential.getUserId())) {
            User user = UserDataManager.load(credential.getUserId());
            if (credential.getPassword().equals(user.getPassword())) {
                user.setIsAuthenticated(true);
                return new Response(ResponseCode.OPERATION_SUCCESSFUL.getCode(), "Successful login", credential.getUserId());
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
    public boolean isAuthenticated(String userId) {
        if (UserDataManager.checkExistence(userId)) {
            User user = UserDataManager.load(userId);
            return user.isAuthenticated();
        }
        return false;
    }

    /**
     * Invalidates a {@code User} only if it exists and is authenticated
     *
     * @param   userId the user id of the corresponding {@code User} that needs to be invalidate
     * @return  {@code Response} with 200 if log out operation is successful,
     *          with 101 if {@code User} is already invalidated or does not exist
     */
    public Response invalidate(String userId) {
        if (UserDataManager.checkExistence(userId)) {
            if (!UserDataManager.load(userId).isAuthenticated()) {
                return new Response(ResponseCode.AUTHENTICATION_FAILED.getCode(), "User is already logged out from the system");
            }
            UserDataManager.load(userId).setIsAuthenticated(false);
            return new Response(ResponseCode.OPERATION_SUCCESSFUL.getCode(), "User is successfully logged out from the system");
        }
        return new Response(ResponseCode.OPERATION_FAILED.getCode(), "Invalid user id");
    }

    /**
     * Generate a bad response when authentication is failed
     *
     * @return Authentication failed {@code Response}
     */
    public Response getFailedAuthResponse() {
        return new Response(ResponseCode.AUTHENTICATION_FAILED.getCode(), "User is not authenticated");
    }

}
