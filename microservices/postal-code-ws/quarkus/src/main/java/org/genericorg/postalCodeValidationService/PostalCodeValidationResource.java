package org.genericorg;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/postalCode-ws")
public class PostalCodeValidationResource {

    @Inject GreetingService greetingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage greeting() {
        return new ResponseMessage(greetingService.greeting("Postal Code Validation"));
    }

    @GET
    @Path("/validation")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage validationRoot() {
        return new ResponseMessage(validationGuidance());
    }

    @GET
    @Path("/validation/{postalCode}/")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage validationPostalOnly() {
        return new ResponseMessage(validationGuidance());
    }


    private String validationGuidance() {
        return "Please provide a postal code and a provice as separate URI params (Postal Code / Province Code)";
    }

    @GET
    @Path("/validation/{postalCode}/{provinceCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Validation validate(@PathParam("postalCode") String postalCode, @PathParam("provinceCode") String provinceCode) {
        PostalCode postalCodeValidation = new PostalCode(postalCode, provinceCode);
        return postalCodeValidation.validate("-1");
    }

}
