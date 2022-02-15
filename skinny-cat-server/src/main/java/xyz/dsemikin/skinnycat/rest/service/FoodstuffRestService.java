package xyz.dsemikin.skinnycat.rest.service;

import xyz.dsemikin.skinnycat.rest.dto.FoodstuffDtoRest;
import xyz.dsemikin.skinnycat.rest.mapper.FoodstuffMapperDtoRest;
import xyz.dsemikin.skinnycat.service.FoodstuffService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public List<FoodstuffDtoRest> all() {
        return mapper.toDtoList(foodstuffService.all());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public FoodstuffDtoRest getById(@PathParam("id") Long id) {
        // TODO: Validate arg
        // TODO: Validate response
        return mapper.toDto(foodstuffService.findById(id).get());
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
    public Response delete(@PathParam("id") Long id) {
        // TODO: Validate arg
        foodstuffService.delete(id);
        return Response.status(204).build();
    }

}
