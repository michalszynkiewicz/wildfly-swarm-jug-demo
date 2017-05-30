package pl.torunjug.swarm.entrystore.entry;

import org.jboss.logging.Logger;
import org.wildfly.swarm.jaxrs.btm.zipkin.ClientRequestInterceptor;
import org.wildfly.swarm.jaxrs.btm.zipkin.ClientResponseInterceptor;

import javax.enterprise.context.ApplicationScoped;
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

    public String getQuote() {
        Response response = ClientBuilder.newClient()
                .register(new ClientRequestInterceptor()).register(new ClientResponseInterceptor())
                .target("http://localhost:8111/quotes")
                .request().get();

        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        } else {
            log.error("Unable to retrieve quote from quote service, status code: " + response.getStatus());
            return "The answer to the ultimate question of life, the universe and everything is 42.";
        }
    }
}
