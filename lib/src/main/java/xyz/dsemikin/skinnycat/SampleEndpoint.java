package xyz.dsemikin.skinnycat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("tutorial")
public class SampleEndpoint {
    @GET
    @Path("helloworld")
    public String helloWorld() {
        return "Hello World!";
    }
}
