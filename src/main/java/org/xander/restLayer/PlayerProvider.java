package org.xander.restLayer;

import org.codehaus.jackson.map.ObjectMapper;
import org.xander.model.Player;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces({MediaType.APPLICATION_JSON})
public class PlayerProvider implements MessageBodyWriter<Player> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean isWriteable(Class<?> type,
                               Type genericType,
                               Annotation[] annotations,
                               MediaType mediaType) {
        return type == Player.class;
    }

    @Override
    public long getSize(Player player,
                        Class<?> type,
                        Type genericType,
                        Annotation[] annotations,
                        MediaType mediaType) {
        // deprecated by JAX-RS 2.0 and ignored by Jersey runtime
        return 0;
    }

    @Override
    public void writeTo(Player player,
                        Class<?> type,
                        Type genericType,
                        Annotation[] annotations,
                        MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException, WebApplicationException {

//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
//
//            jaxbContext.createMarshaller().marshal(player, entityStream);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        objectMapper.writeValue(entityStream, player);
    }
}
