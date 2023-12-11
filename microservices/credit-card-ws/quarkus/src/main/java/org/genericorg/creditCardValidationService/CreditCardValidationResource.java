package org.genericorg;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/creditCard-ws")
public class CreditCardValidationResource {

    @Inject GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return greetingService.greeting("Credit Card Validation");
    }

    @GET
    @Path("/validation")
    @Produces(MediaType.TEXT_PLAIN)
    public String validationGuidance() {
        return "Please provide a credit card number as a URI param";
    }

    @GET
    @Path("/validation/{creditCardNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Validation validate(@PathParam("creditCardNumber") String creditCardNumber) {
        CreditCard creditCard = new CreditCard(creditCardNumber);
        return creditCard.validate();
    }

}
