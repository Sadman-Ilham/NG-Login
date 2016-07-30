package com.sadman.nglogin.provider;

import com.sadman.nglogin.service.UserAuthenticator;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sadman
 * @since Jul 29, 2016
 */
public class UserRequestFilter implements ContainerRequestFilter {

    private static final String BASE_URI = "http://localhost:8085/api/";
    private static final String INVALID_REQUEST_URI = "http://localhost:8085/api/user/error";
    private static final Set<String> nonRestrictedURISet = new HashSet<>(Arrays
            .asList("http://localhost:8085/api/user/register", "http://localhost:8085/api/user/authenticate"));

    /**
     * Filters client requests, so that unauthenticated users can not get access to the restricted api
     *
     * @param containerRequest {@code ContainerRequest}
     * @return {@code containerRequest} with changed request uri if request is invalid
     */
    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) {
        if (this.isFilterAllowed(containerRequest.getRequestUri().toString())) {
            UserAuthenticator authenticator = new UserAuthenticator();
            List<String> userId = containerRequest.getRequestHeader("userId");
            if (userId != null && !authenticator.isAuthenticated(userId.get(0))) {
                try {
                    containerRequest.setUris(new URI(BASE_URI), new URI(INVALID_REQUEST_URI));
                } catch (URISyntaxException e) {e.printStackTrace();}
            }
        }
        return containerRequest;
    }

    /**
     * Checks if the provided URI is allowed for filtering or not
     *
     * @param requestURI Requested URI that needs to be checked
     * @return {@code true} if the provided URI is allowed for filtering, {@code false} otherwise.
     */
    private boolean isFilterAllowed(String requestURI) {
        return !nonRestrictedURISet.contains(requestURI);
    }

}
