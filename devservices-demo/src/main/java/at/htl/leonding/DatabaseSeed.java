package at.htl.leonding;

import at.htl.leonding.entity.Person;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DatabaseSeed {
    @Inject
    EntityManager em;
    @Transactional
    void startup(@Observes StartupEvent ev) {
        Person person = new Person("johndoe2@gmail.com",22,"doe","john");
        Person person2 = new Person("marryjoe@gmail.com",25,"doe","marry");
        Person person3 = new Person("foodoe2@gmail.com",29,"doe","foo");

        em.persist(person);
        em.persist(person2);
        em.persist(person3);
    }
}
