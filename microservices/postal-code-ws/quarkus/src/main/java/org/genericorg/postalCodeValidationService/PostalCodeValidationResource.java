package org.genericorg;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/postalCode-ws")
public class PostalCodeValidationResource {

    @Inject GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return greetingService.greeting("Postal Code Validation");
    }

    @GET
    @Path("/validation")
    @Produces(MediaType.TEXT_PLAIN)
    public String validationRoot() {
        return validationGuidance();
    }

    @GET
    @Path("/validation/{postalCode}/")
    @Produces(MediaType.TEXT_PLAIN)
    public String validationPostalOnly() {
        return validationGuidance();
    }


    private String validationGuidance() {
        return "Please provide a postal code and a provice as separate URI params";
    }

    /*
    @GET
    @Path("/validation/{postalCode}/{province}")
    @Produces(MediaType.TEXT_PLAIN)
    public String validate(@PathParam("postalCode") String postalCode, @PathParam("province") String province) {
        return String.format("Example response with URI param values (%s, %s)", postalCode, province);
    }
    */

    ///*
    @GET
    @Path("/validation/{postalCode}/{provinceCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Validation validate(@PathParam("postalCode") String postalCode, @PathParam("provinceCode") String provinceCode) {
        PostalCode postalCodeValidation = new PostalCode(postalCode, provinceCode);
        return postalCodeValidation.validate("-1");
    }
    //*/
    
}
