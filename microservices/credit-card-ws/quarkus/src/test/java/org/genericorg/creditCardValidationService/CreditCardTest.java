package org.genericorg;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CreditCardTest {

    @Test
    public void testValidateValidAmericanExpress() {
        CreditCard ccInstance = new CreditCard("378282246310005");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidAmericanExpressCorporate() {
        CreditCard ccInstance = new CreditCard("378734493671000");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidAmericanExpressTooShort() {
        CreditCard ccInstance = new CreditCard("37828224631000");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidAmericanExpressTooLong() {
        CreditCard ccInstance = new CreditCard("3782822463100050");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidDinersClub() {
        CreditCard ccInstance = new CreditCard("30569309025904");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidDinersClubTooShort() {
        CreditCard ccInstance = new CreditCard("3056930902590");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidDinersClubTooLong() {
        CreditCard ccInstance = new CreditCard("305693090259040");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidDiscover() {
        CreditCard ccInstance = new CreditCard("6011000990139424");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidDiscoverTooShort() {
        CreditCard ccInstance = new CreditCard("601100099013942");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidDiscoverTooLong() {
        CreditCard ccInstance = new CreditCard("60110009901394240");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidJCB() {
        CreditCard ccInstance = new CreditCard("3530111333300000");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidJCBTooShort() {
        CreditCard ccInstance = new CreditCard("353011133330000");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidJCBTooLong() {
        CreditCard ccInstance = new CreditCard("35301113333000000");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidMasterCard() {
        CreditCard ccInstance = new CreditCard("5555555555554444");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidMasterCardTooShort() {
        CreditCard ccInstance = new CreditCard("555555555555444");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidMasterCardTooLong() {
        CreditCard ccInstance = new CreditCard("55555555555544440");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidVisa13Digits() {
        CreditCard ccInstance = new CreditCard("4222222222222");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidVisa13DigitsTooShort() {
        CreditCard ccInstance = new CreditCard("422222222222");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidVisa13DigitsTooLong() {
        CreditCard ccInstance = new CreditCard("42222222222222");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateValidVisa16Digits() {
        CreditCard ccInstance = new CreditCard("4012888888881881");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertTrue(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidVisa16DigitsTooShort() {
        CreditCard ccInstance = new CreditCard("401288888888188");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidVisa16DigitsTooLong() {
        CreditCard ccInstance = new CreditCard("40128888888818810");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidPreceedingAlpha() {
        CreditCard ccInstance = new CreditCard("a401288888888188");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidSucceedingAlpha() {
        CreditCard ccInstance = new CreditCard("401288888888188a");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidSurroundingAlpha() {
        CreditCard ccInstance = new CreditCard("a40128888888818a");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateInvalidEmbeddedAlpha() {
        CreditCard ccInstance = new CreditCard("40128888a8888188");
        Validation ccValidation = ccInstance.validate("1");
        Assertions.assertFalse(ccValidation.getMessage().contains("Valid."));
    }
}
