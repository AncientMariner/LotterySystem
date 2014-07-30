package org.xander.restLayer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class DrawResultsServiceTest {
    // TODO should be run initially by starting the app
    @Ignore
    @Test
    public void emptyPlayers() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/drawResults/players");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("result is empty", response.getEntity(String.class));
    }

    // TODO should be run initially by starting the app
    @Ignore
    @Test
    public void emptyWinners() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/drawResults/winners");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

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
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("result is empty", response.getEntity(String.class));
    }
}
