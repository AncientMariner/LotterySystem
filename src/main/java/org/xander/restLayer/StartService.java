package org.xander.restLayer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.Status.TEMPORARY_REDIRECT;

@Path("/")
public class StartService {
    @GET
    @Path("/")
    public Response defaultURL(@Context UriInfo uriInfo) {
        return Response.status(TEMPORARY_REDIRECT).location(URI.create(uriInfo.getAbsolutePath() + "rest")).build();
    }

    @GET
    @Path("/rest")
    public Response getMsg(@Context UriInfo uriInfo) {
        String output = "This is start page, here is the list of possible requests:"+ " <br /><br />"
                + uriInfo.getAbsolutePath() + "/player/generation/{name} {PUT} " + "<br />"
                + uriInfo.getAbsolutePath() + "/draw/generation {PUT} " + "<br />"
                + uriInfo.getAbsolutePath() + "/drawResults/players {GET} " + "<br />"
                + uriInfo.getAbsolutePath() + "/drawResults/tickets {GET} " + "<br />"
                + uriInfo.getAbsolutePath() + "/drawResults/winners {GET} " + "<br />";
        return Response.status(OK).entity(output).build();
    }
}
