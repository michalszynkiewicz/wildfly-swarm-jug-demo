package pl.torunjug.swarm.entrystore.entry;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 *         <br>
 *         Date: 5/30/17
 */
@Consumes("application/json")
@Produces("application/json")
@Path("/entries")
public class EntryEndpoint {

    @Inject
    private EntryDao entryDao;

    @GET
    public List<Entry> getAll() {
        return entryDao.getAll();
    }

    @POST
    public Entry save(Entry entry) {
        return entryDao.save(entry);
    }


}
