package org.xander.restLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.xander.userScenario.DrawGeneration;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rest/draw")
public class GenerateDrawService {
    @Autowired
    DrawGeneration drawGeneration;

    public GenerateDrawService(DrawGeneration drawGeneration) {
        this.drawGeneration = drawGeneration;
    }

    @PUT
    @Path("/generation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayers() {
        drawGeneration.generate();
        String result = "draw is generated";
        return Response.ok(result).build();
    }
}
