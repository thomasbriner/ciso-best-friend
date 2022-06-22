package org.acme;

import io.quarkus.security.Authenticated;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @GET()
    @Path("welcome")
    @Produces(MediaType.TEXT_PLAIN)
    public String welcome() {
        return "Public";
    }

    @GET
    @Path("user")
    @Authenticated
    @Produces(MediaType.TEXT_PLAIN)
    public String user() {
        return "user";
    }

    @GET
    @Path("admin")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String admin() {
        return "admin";
    }

}
