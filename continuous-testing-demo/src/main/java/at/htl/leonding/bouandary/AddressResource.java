package at.htl.leonding.bouandary;

import at.htl.leonding.entity.Address;
import at.htl.leonding.repository.AddressRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    AddressRepository addressRepository;

    @GET
    @Path("/all")
    public List<Address> getAllAddresses() {
        return addressRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getAddressById(@PathParam("id") Long id) {

        Address address = addressRepository.findById(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(address).build();
    }

    @POST
    public Response createAddress(Address address) {
        addressRepository.persist(address);
        return Response.status(Response.Status.CREATED).entity(address).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAddress(@PathParam("id") Long id, Address updatedAddress) {
        Address address = addressRepository.findById(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setZipCode(updatedAddress.getZipCode());
        addressRepository.persist(address);
        return Response.ok(address).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAddress(@PathParam("id") Long id) {
        boolean deleted = addressRepository.deleteById(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
