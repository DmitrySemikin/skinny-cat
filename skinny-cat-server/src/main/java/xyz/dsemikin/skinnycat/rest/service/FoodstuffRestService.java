package xyz.dsemikin.skinnycat.rest.service;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.rest.dto.FoodstuffDtoRest;
import xyz.dsemikin.skinnycat.rest.mapper.FoodstuffMapperDtoRest;
import xyz.dsemikin.skinnycat.service.FoodstuffService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/foodstuff")
public class FoodstuffRestService {

    @Inject
    private FoodstuffService foodstuffService;

    @Inject
    private FoodstuffMapperDtoRest mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Foodstuff> all() {
        return foodstuffService.all();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Foodstuff getById(@QueryParam("id") Long id) {
        // TODO: Validate arg
        // TODO: Validate response
        return foodstuffService.findById(id).get();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(final FoodstuffDtoRest foodstuff) {
        // TODO: Validate argument (in the service or mapper actually)
        foodstuffService.put(mapper.fromDto(foodstuff));
        return Response.status(201).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@QueryParam("id") Long id) {
        // TODO: Validate arg
        foodstuffService.delete(id);
        return Response.status(204).build();
    }

}
