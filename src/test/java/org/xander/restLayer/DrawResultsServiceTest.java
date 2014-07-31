package org.xander.restLayer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class DrawResultsServiceTest {
    // TODO should be run initially by starting the app
    @Ignore
    @Test
    public void emptyPlayers() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/drawResults/players");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("null", response.getEntity(String.class));
    }

    // TODO should be run initially by starting the app
    @Ignore
    @Test
    public void emptyWinners() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/drawResults/winners");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("no winners, please try next time", response.getEntity(String.class));
    }

    // TODO should be run initially by starting the app
    @Ignore
    @Test
    public void emptyTickets() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/drawResults/tickets");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("result is empty", response.getEntity(String.class));
    }

    @Test
    public void generateTickets() {
        Client client = Client.create();
        String name = "Alan";
        String basicURL = "http://localhost:8080/rest";

        generatePlayer(client, name, basicURL);
        generateDraw(client, basicURL);
        ClientResponse responseResultTickets = getResultTickets(client, basicURL);

        //number is random every time thus no clear test result
        assertNotSame("result is empty", responseResultTickets.getEntity(String.class));
    }

    private ClientResponse getResultTickets(Client client, String basicURL) {
        WebResource webResourceResultTickets = client.resource(basicURL + "/drawResults/tickets");
        ClientResponse responseResultTickets = webResourceResultTickets.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (responseResultTickets.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + responseResultTickets.getStatus());
        }
        return responseResultTickets;
    }

    private void generateDraw(Client client, String basicURL) {
        WebResource webResourceDrawGeneration = client.resource(basicURL + "/draw/generation");
        ClientResponse responseDrawGeneration = webResourceDrawGeneration.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);

        if (responseDrawGeneration.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + responseDrawGeneration.getStatus());
        }
        assertEquals("draw is generated", responseDrawGeneration.getEntity(String.class));
    }

    private void generatePlayer(Client client, String name, String basicURL) {
        WebResource webResourcePlayerGeneration = client.resource(basicURL + "/player/generation/" + name);
        ClientResponse responsePlayerGeneration = webResourcePlayerGeneration.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);

        if (responsePlayerGeneration.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + responsePlayerGeneration.getStatus());
        }
        assertEquals("player " + name + " is generated", responsePlayerGeneration.getEntity(String.class));
    }

    @Test
    public void generatePlayers() {
        Client client = Client.create();
        String name = "Rich";

        String basicURL = "http://localhost:8080/rest";
        generatePlayer(client, name, basicURL);

        ClientResponse responseResultPlayers = getResultPlayers(client, basicURL);

        assertTrue(responseResultPlayers.getEntity(String.class).contains(name));
    }

    private ClientResponse getResultPlayers(Client client, String basicURL) {
        WebResource webResourceResultPlayers = client.resource(basicURL + "/drawResults/players");
        ClientResponse responseResultPlayers = webResourceResultPlayers.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (responseResultPlayers.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + responseResultPlayers.getStatus());
        }
        return responseResultPlayers;
    }
}
