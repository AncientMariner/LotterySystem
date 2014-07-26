package org.xander.restLayer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/")
public class StartService {

    @GET
//    @Path("/")
    public Response getMsg(@Context UriInfo uriInfo) {
        String output = "This is start page, here is the list of possible requests:"+ "<br /><br />"
                + uriInfo.getAbsolutePath() + "player/generation/{name}" + "<br />"
                + uriInfo.getAbsolutePath() + "draw/generation" + "<br />"
                + uriInfo.getAbsolutePath() + "drawResults/players" + "<br />"
                + uriInfo.getAbsolutePath() + "drawResults/tickets" + "<br />"
                + uriInfo.getAbsolutePath() + "drawResults/winners" + "<br />";
        return Response.status(OK).entity(output).build();
    }
}
