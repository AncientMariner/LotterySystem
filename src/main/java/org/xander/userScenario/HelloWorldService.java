package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.xander.dao.DrawHibernateDao;
import org.xander.service.DrawConfigurationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/hello")
public class HelloWorldService {

    @Autowired
    DrawResults drawResults;

    @Autowired
    DrawConfigurationService drawConfigurationService;

    @Autowired
    DrawHibernateDao drawHibernateDao;

    public HelloWorldService(DrawResults drawResults) {
        this.drawResults = drawResults;
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;
        System.out.println(drawResults.getPlayers());
//
        return Response.status(OK).entity(output).build();
    }
}