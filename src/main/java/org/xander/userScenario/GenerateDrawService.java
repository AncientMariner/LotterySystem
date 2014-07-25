package org.xander.userScenario;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/draw")
public class GenerateDrawService {
    @Autowired
    CalculateDraw calculateDraw;

    public GenerateDrawService(CalculateDraw calculateDraw) {
        this.calculateDraw = calculateDraw;
    }

    @PUT
    @Path("/generation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayers() {
        calculateDraw.generateDraw();
        String result = "draw is generated";
        return Response.ok(result).build();
    }
}
