package pl.torunjug.swarm.entrystore.entry;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.inject.Inject;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 *         <br>
 *         Date: 5/30/17
 */
@RunWith(Arquillian.class)
@DefaultDeployment
public class EntryEndpointTest {
    @Inject
    private EntryEndpoint entryEndpoint;

    
    @Test
    public void shouldAddAndGetEntry() {
        String testContent = "testContent";

        Entry entry = new Entry();
        entry.setContent(testContent);
        entryEndpoint.save(entry);

        List<Entry> all = entryEndpoint.getAll();

        Optional<Entry> maybeEntry = all.stream().filter(e -> testContent.equals(e.getContent())).findAny();
        assertTrue(maybeEntry.isPresent());
    }
}