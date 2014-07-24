package org.xander.userScenario;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/")
public class StartService {

    @GET
    @Path("/")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getMsg() {
//        String requestURI = session.getServletContext().getServerInfo();
        String output = "This is start page, content will follow ";
        return Response.status(OK).entity(output).build();
    }
}
