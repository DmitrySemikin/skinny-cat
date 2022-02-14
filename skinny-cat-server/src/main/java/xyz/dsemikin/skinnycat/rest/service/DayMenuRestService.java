package xyz.dsemikin.skinnycat.rest.service;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("tutorial")
public class DayMenuRestService {
    @GET
    @Path("helloworld")
    public String helloWorld() {
        return "Hello World!";
    }
}
