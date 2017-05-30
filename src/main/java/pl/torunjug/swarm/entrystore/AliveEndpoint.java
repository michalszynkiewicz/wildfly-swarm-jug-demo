package pl.torunjug.swarm.entrystore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 *         <br>
 *         Date: 5/30/17
 */
@Path("/alive")
public class AliveEndpoint {
    @GET
    public Response isAlive() {
        return Response.ok().build();
    }
}
