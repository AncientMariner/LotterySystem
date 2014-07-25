package org.xander.userScenario;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerGenerationServiceTest {
    @Test
    public void generatePlayer() {
        Client client = Client.create();
        String name = "Alan";
        WebResource webResource = client.resource("http://localhost:8080/rest/player/generation/" + name);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("player " + name + " is generated", response.getEntity(String.class));
    }

    @Test
    public void generatePlayerWithEmptyName() {
        Client client = Client.create();
        String name = "";
        WebResource webResource = client.resource("http://localhost:8080/rest/player/generation/" + name);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        assertEquals(404, response.getStatus());

        String nullName = "";
        WebResource webResource1 = client.resource("http://localhost:8080/rest/player/generation/" + nullName);
        ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
        assertEquals(404, response1.getStatus());

    }
}
