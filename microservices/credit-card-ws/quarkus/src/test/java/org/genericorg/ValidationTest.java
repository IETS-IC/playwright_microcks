package org.genericorg;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ValidationTest {

    @Test
    public void testConstructor() {
        Validation validation = new Validation("42", false, "Unit Test Text");
        Assertions.assertEquals("42", validation.getID());
        Assertions.assertEquals(false, validation.getValid());
        Assertions.assertEquals("Unit Test Text", validation.getMessage());
    }
}
