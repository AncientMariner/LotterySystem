package org.xander.userScenario;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xander.model.Player;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/drawResults")
public class DrawResultsService {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    DrawResults drawResults;

    public DrawResultsService(DrawResults drawResults) {
        this.drawResults = drawResults;
    }

    @GET
    @Path("/players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayers() {

        List<Player> players = drawResults.getPlayers();
        String result = null;
        if (players.isEmpty()) {
            result = "result is empty";
        } else {
            try {
                Object json = mapper.writeValueAsString(players);
                result = mapper.writeValueAsString(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok(result).build();
    }

    @GET
    @Path("/winners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWinners() {

        List<Player> players = drawResults.getWinners();
        String result = null;
        if (players.isEmpty()) {
            result = "result is empty";
        } else {
            try {
                Object json = mapper.writeValueAsString(players);
                result = mapper.writeValueAsString(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok(result).build();
    }

    @GET
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTickets() {

        List<Integer> tickets = drawResults.getTickets();
        String result = null;
        if (tickets.isEmpty()) {
            result = "result is empty";
        } else {
            try {
                Object json = mapper.writeValueAsString(tickets);
                result = mapper.writeValueAsString(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok(result).build();
    }
}