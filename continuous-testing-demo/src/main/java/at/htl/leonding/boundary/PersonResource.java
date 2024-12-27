package at.htl.leonding.boundary;

import at.htl.leonding.entity.Person;
import at.htl.leonding.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/all")
    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") Long id) {
        Person person = personRepository.findById(id);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(person).build();

    }

    @POST
    public Response createPerson(Person person) {
        personRepository.persist(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") Long id, Person updatedPerson) {
        Person person = personRepository.findById(id);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        person.setFirstName(updatedPerson.getFirstName());
        person.setLastName(updatedPerson.getLastName());
        person.setAge(updatedPerson.getAge());
        person.setEmail(updatedPerson.getEmail());
        person.setHoursWorked(updatedPerson.getHoursWorked());
        person.setHourlyWage(updatedPerson.getHourlyWage());
        person.setAddress(updatedPerson.getAddress());
        personRepository.persist(person);
        return Response.ok(person).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        boolean deleted = personRepository.deleteById(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
