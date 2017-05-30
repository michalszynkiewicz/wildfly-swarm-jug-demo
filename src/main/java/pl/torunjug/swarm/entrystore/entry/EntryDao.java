package pl.torunjug.swarm.entrystore.entry;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 *         <br>
 *         Date: 5/30/17
 */
@ApplicationScoped
public class EntryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Entry> getAll() {
        return entityManager.createQuery("FROM Entry", Entry.class).getResultList();
    }

    @Transactional
    public Entry save(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }
}
