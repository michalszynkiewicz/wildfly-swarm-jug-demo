package pl.torunjug.swarm.entrystore.entry;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 *         <br>
 *         Date: 5/30/17
 */
@ApplicationScoped
public class QuoteService {
    private static final Logger log = Logger.getLogger(QuoteService.class);
    public static final String DEFAULT_QUOTE = "The answer to the ultimate question of life, the universe and everything is 42.";

    public String getQuote() {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            Response response = client
                    .target("http://quotegenerator.jug.svc.local/quotes")
                    .request().get();

            if (response.getStatus() == 200) {
                return response.readEntity(String.class);
            } else {
                log.error("Unable to retrieve quote from quote service, status code: " + response.getStatus());
                return DEFAULT_QUOTE;
            }
        } catch (RuntimeException any) {
            any.printStackTrace();
            return DEFAULT_QUOTE;
        } finally {

        }
    }
}
