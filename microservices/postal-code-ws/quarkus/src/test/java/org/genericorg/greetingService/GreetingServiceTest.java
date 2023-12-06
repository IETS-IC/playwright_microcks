package org.genericorg;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingServiceTest {

    @Inject GreetingService greetingService;

    @Test
    public void testGreeting() {
        String greeting = greetingService.greeting("Unit Test");
        Assertions.assertTrue(greeting.contains("Hello"));
        Assertions.assertTrue(greeting.contains("Unit Test"));
        Assertions.assertTrue(greeting.contains("service"));
    }

}
