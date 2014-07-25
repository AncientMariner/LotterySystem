package org.xander.userScenario;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenerateDrawServiceTest {
    @Test
    public void generateDraw() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/draw/generation");
        ClientResponse response = webResource.accept("application/json").put(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("draw is generated", response.getEntity(String.class));
    }
}
