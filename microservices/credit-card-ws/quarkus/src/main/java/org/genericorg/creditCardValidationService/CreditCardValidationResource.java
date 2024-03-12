package org.genericorg;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/creditCard-ws")
public class CreditCardValidationResource {

    @Inject GreetingService greetingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage greeting() {
        return new ResponseMessage(greetingService.greeting("Credit Card Validation"));
    }

    @GET
    @Path("/validation")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage validationGuidance() {
        return new ResponseMessage("Please provide a credit card number as a URI param");
    }

    @GET
    @Path("/validation/{creditCardNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Validation validate(@PathParam("creditCardNumber") String creditCardNumber) {
        CreditCard creditCard = new CreditCard(creditCardNumber);
        return creditCard.validate();
    }

}
