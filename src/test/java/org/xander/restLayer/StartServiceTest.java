package org.xander.restLayer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class StartServiceTest {
    @Test
    public void startPage() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest");
        ClientResponse response = webResource.accept("*/*").get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("This is start page, here is the list of possible requests: <br /><br />" +
                "http://localhost:8080/rest/player/generation/{name} {PUT} <br />" +
                "http://localhost:8080/rest/draw/generation {PUT} <br />" +
                "http://localhost:8080/rest/drawResults/players {GET} <br />" +
                "http://localhost:8080/rest/drawResults/tickets {GET} <br />" +
                "http://localhost:8080/rest/drawResults/winners {GET} <br />", response.getEntity(String.class));
    }

    @Test
    public void defaultPage() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/");
        ClientResponse response = webResource.accept("*/*").get(ClientResponse.class);

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        assertEquals("This is start page, here is the list of possible requests: <br /><br />" +
                "http://localhost:8080/rest/player/generation/{name} {PUT} <br />" +
                "http://localhost:8080/rest/draw/generation {PUT} <br />" +
                "http://localhost:8080/rest/drawResults/players {GET} <br />" +
                "http://localhost:8080/rest/drawResults/tickets {GET} <br />" +
                "http://localhost:8080/rest/drawResults/winners {GET} <br />", response.getEntity(String.class));
    }
}
