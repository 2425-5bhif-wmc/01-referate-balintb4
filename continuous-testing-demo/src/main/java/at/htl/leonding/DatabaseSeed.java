package at.htl.leonding;

import at.htl.leonding.entity.Person;
import at.htl.leonding.entity.Address;
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
        Address address1 = new Address("Main Street 1", "Vienna", "1010");
        Address address2 = new Address("High Street 5", "Salzburg", "5020");
        Address address3 = new Address("Broadway 10", "Linz", "4020");

        Person person1 = new Person("John", "Doe", 30, "johndoe@gmail.com", 40, 20, address1);
        Person person2 = new Person("Marry", "Joe", 25, "marryjoe@gmail.com", 35, 18, address2);
        Person person3 = new Person("Foo", "Doe", 29, "foodoe@gmail.com", 45, 25, address3);

        // Persistiere die Objekte
        em.persist(person1);
        em.persist(person2);
        em.persist(person3);


    }
}
