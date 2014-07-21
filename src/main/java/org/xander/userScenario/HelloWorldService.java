package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/hello")
public class HelloWorldService {

    @Autowired
    DrawResults drawResults;

	@GET
    @Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
//        drawResults.getPlayers();
        return Response.status(OK).entity(output).build();
	}
}