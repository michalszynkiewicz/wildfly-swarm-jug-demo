package pl.torunjug.swarm.entrystore.entry;

import org.jboss.logging.Logger;

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

    private static final Logger log = Logger.getLogger(EntryEndpoint.class);

    @Inject
    private EntryDao entryDao;

    @Inject
    private QuoteService quoteService;

    @GET
    public List<Entry> getAll() {
        log.warn("listing all entries without max count.");
        return entryDao.getAll();
    }

    @POST
    public Entry save(Entry entry) {
        log.info("adding entry with content: " + entry.getContent());
        if (entry.getQuote() == null) {
            entry.setQuote(quoteService.getQuote());
        }
        return entryDao.save(entry);
    }

}
