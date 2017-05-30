package pl.torunjug.swarm.entrystore;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSFraction;
import org.wildfly.swarm.topology.consul.ConsulTopologyFraction;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 *         <br>
 *         Date: 5/30/17
 */
public class App {
    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm(args);
        swarm.fraction(new ConsulTopologyFraction("http://localhost:8500"));
        swarm.start().deploy();
    }
}
