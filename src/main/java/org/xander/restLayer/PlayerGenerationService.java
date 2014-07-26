package org.xander.restLayer;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xander.userScenario.PlayerGeneration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
public class PlayerGenerationService {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    PlayerGeneration playerGeneration;

    public PlayerGenerationService(PlayerGeneration playerGeneration) {
        this.playerGeneration = playerGeneration;
    }

    @PUT
    @Path("/generation/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("name") String name) {
        if (name != null && !name.isEmpty()) {
            playerGeneration.generatePlayer(name);
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("name is invalid").build();
        }

//        Object json = null;
//        try {
//            json = mapper.writeValueAsString(generatedPlayer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return Response.ok("player " + name + " is generated").build();
    }
}
