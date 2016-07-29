package com.sadman.nglogin.controller;

import com.sadman.nglogin.model.Credential;
import com.sadman.nglogin.model.Response;
import com.sadman.nglogin.model.User;
import com.sadman.nglogin.service.UserAuthenticator;
import com.sadman.nglogin.service.UserDetailsRetriever;
import com.sadman.nglogin.service.UserRegistrant;
import com.sadman.nglogin.utils.UserDataManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * It controls {@code User} functionality
 *
 * @author Sadman
 * @since Jul 28, 2016
 */
@Path("/user")
public class UserController {

    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response register(User user) {
        UserRegistrant registrant = new UserRegistrant();
        return registrant.register(user);
    }

    @POST
    @Path("/authenticate")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response authenticate(Credential credential) {
        UserAuthenticator authenticator = new UserAuthenticator();
        return authenticator.authenticate(credential);
    }

    @GET
    @Path("/details/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDetails(@PathParam("userId") String userId) {
        UserDetailsRetriever detailsRetriever = new UserDetailsRetriever();
        return detailsRetriever.getUserDetails(userId);
    }

    @POST
    @Path("/invalidate")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response invalidate(String userId) {
        UserAuthenticator authenticator = new UserAuthenticator();
        return authenticator.invalidate(userId);
    }

    @GET
    @Path("/invalid")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBadResponse() {
        return new Response(401, "User is not authenticated");
    }

}
