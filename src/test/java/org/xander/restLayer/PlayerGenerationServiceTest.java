package org.xander.restLayer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class PlayerGenerationServiceTest {
    @Test
    public void generatePlayer() {
        Client client = Client.create();
        String name = "Alan";
        WebResource webResource = client.resource("http://localhost:8080/rest/player/generation/" + name);
        ClientResponse response = webResource.accept("application/json").put(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("player " + name + " is generated", response.getEntity(String.class));
    }

    @Test
    public void generatePlayerWithEmptyName() {
        Client client = Client.create();
        String name = "";
        String partOfTheURL = "http://localhost:8080/rest/player/generation/";
        WebResource webResourceWithEmptyName = client.resource(partOfTheURL + name);
        ClientResponse responseWithEmptyName = webResourceWithEmptyName.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), responseWithEmptyName.getStatus());

        String nullName = "";

        WebResource webResourceWithNullName = client.resource(partOfTheURL + nullName);
        ClientResponse responseWithNullName = webResourceWithNullName.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), responseWithNullName.getStatus());

    }
}
