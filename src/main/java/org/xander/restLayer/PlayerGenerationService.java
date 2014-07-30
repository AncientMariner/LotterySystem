package org.xander.restLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.xander.model.Player;
import org.xander.userScenario.PlayerGeneration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rest/player")
public class PlayerGenerationService {

    @Autowired
    PlayerGeneration playerGeneration;

    public PlayerGenerationService(PlayerGeneration playerGeneration) {
        this.playerGeneration = playerGeneration;
    }

    @PUT
    @Path("/generation/{name}")
    public Response putPlayer(@PathParam("name") String name) {
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


    //without provider version
    @GET
    @Path("/getPlayer/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(@PathParam("name") String name) {
        Player player = playerGeneration.getPlayerService().getByName(name);

        return player;

//        return Response.ok().entity(player).build();
    }
}
