package at.htl.leonding.bouandary;

import at.htl.leonding.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("person")
public class PersonResource {
    @Inject
    PersonRepository personRepository;
    @GET
    @Path("/all")
    public Response getAllPersons() {
        if (personRepository.count() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(personRepository.findAll().list()).build();
    }
}
