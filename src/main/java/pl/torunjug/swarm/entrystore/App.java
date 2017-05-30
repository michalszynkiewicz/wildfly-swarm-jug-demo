package pl.torunjug.swarm.entrystore;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.config.logging.Level;
import org.wildfly.swarm.jaxrs.btm.ZipkinFraction;
import org.wildfly.swarm.logstash.LogstashFraction;
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
        swarm
                .fraction(
                        new ConsulTopologyFraction("http://localhost:8500")
                ).fraction(
                        new LogstashFraction().hostname("localhost").port(9300).level(Level.INFO)
                ).fraction(
                        new ZipkinFraction("entries")
                                .sampleRate(1.0f)
                                .reportAsync("http://localhost:9411/api/v1/spans")
        );
        swarm.start().deploy();
    }
}
