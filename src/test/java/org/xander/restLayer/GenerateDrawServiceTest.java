package org.xander.restLayer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class GenerateDrawServiceTest {
    @Test
    public void generateDraw() {
        Client client = Client.create();
        String URL = "http://localhost:8080/rest/draw/generation";
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.ordinal()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("draw is generated", response.getEntity(String.class));
    }
}
