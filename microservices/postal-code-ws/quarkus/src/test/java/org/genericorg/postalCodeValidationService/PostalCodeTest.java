package org.genericorg;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PostalCodeTest {

    @Test
    public void testValidatePatternValidNoSpace() {
        PostalCode postalCodeInstance = new PostalCode("A1A1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("1");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternValidWithEmbeddedSpace() {
        PostalCode postalCodeInstance = new PostalCode("A1A 1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("2");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternValidHyphenSeparator() {
        PostalCode postalCodeInstance = new PostalCode("A1A-1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("3");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidPrecedingAlpha() {
        PostalCode postalCodeInstance = new PostalCode("aA1A1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("4");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidSucceedingAlpha() {
        PostalCode postalCodeInstance = new PostalCode("A1A1A1a", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("5");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidSurroundingAlpha() {
        PostalCode postalCodeInstance = new PostalCode("aA1A1A1a", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("6");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidEmbeddedAlpha() {
        PostalCode postalCodeInstance = new PostalCode("A1Aa1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("7");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidFirstPosition() {
        PostalCode postalCodeInstance = new PostalCode("11A1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("8");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidSecondPosition() {
        PostalCode postalCodeInstance = new PostalCode("AAA1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("9");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidThirdPosition() {
        PostalCode postalCodeInstance = new PostalCode("A111A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("10");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidFourthPosition() {
        PostalCode postalCodeInstance = new PostalCode("A1AAA1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("11");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidFifthPosition() {
        PostalCode postalCodeInstance = new PostalCode("A1A111", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("12");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePatternInvalidSixthPosition() {
        PostalCode postalCodeInstance = new PostalCode("A1A1AA", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("13");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeABValidT() {
        PostalCode postalCodeInstance = new PostalCode("T1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("14");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeBCValidV() {
        PostalCode postalCodeInstance = new PostalCode("V1A1A1", "BC");
        Validation postalCodeValidation  = postalCodeInstance.validate("15");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeMBValidR() {
        PostalCode postalCodeInstance = new PostalCode("R1A1A1", "MB");
        Validation postalCodeValidation  = postalCodeInstance.validate("16");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNBValidE() {
        PostalCode postalCodeInstance = new PostalCode("E1A1A1", "NB");
        Validation postalCodeValidation  = postalCodeInstance.validate("17");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNLValidA() {
        PostalCode postalCodeInstance = new PostalCode("A1A1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("18");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNSValidB() {
        PostalCode postalCodeInstance = new PostalCode("B1A1A1", "NS");
        Validation postalCodeValidation  = postalCodeInstance.validate("19");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNTValidX() {
        PostalCode postalCodeInstance = new PostalCode("X1A1A1", "NT");
        Validation postalCodeValidation  = postalCodeInstance.validate("20");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNUValidX() {
        PostalCode postalCodeInstance = new PostalCode("X1A1A1", "NU");
        Validation postalCodeValidation  = postalCodeInstance.validate("21");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeONValidK() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "ON");
        Validation postalCodeValidation  = postalCodeInstance.validate("22");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeONValidL() {
        PostalCode postalCodeInstance = new PostalCode("L1A1A1", "ON");
        Validation postalCodeValidation  = postalCodeInstance.validate("23");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeONValidM() {
        PostalCode postalCodeInstance = new PostalCode("M1A1A1", "ON");
        Validation postalCodeValidation  = postalCodeInstance.validate("24");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeONValidN() {
        PostalCode postalCodeInstance = new PostalCode("N1A1A1", "ON");
        Validation postalCodeValidation  = postalCodeInstance.validate("25");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeONValidP() {
        PostalCode postalCodeInstance = new PostalCode("P1A1A1", "ON");
        Validation postalCodeValidation  = postalCodeInstance.validate("26");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodePEValidC() {
        PostalCode postalCodeInstance = new PostalCode("C1A1A1", "PE");
        Validation postalCodeValidation  = postalCodeInstance.validate("27");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeQCValidG() {
        PostalCode postalCodeInstance = new PostalCode("G1A1A1", "QC");
        Validation postalCodeValidation  = postalCodeInstance.validate("28");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeQCValidH() {
        PostalCode postalCodeInstance = new PostalCode("H1A1A1", "QC");
        Validation postalCodeValidation  = postalCodeInstance.validate("29");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeQCValidJ() {
        PostalCode postalCodeInstance = new PostalCode("J1A1A1", "QC");
        Validation postalCodeValidation  = postalCodeInstance.validate("30");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeSKValidS() {
        PostalCode postalCodeInstance = new PostalCode("S1A1A1", "SK");
        Validation postalCodeValidation  = postalCodeInstance.validate("31");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeYTValidY() {
        PostalCode postalCodeInstance = new PostalCode("Y1A1A1", "YT");
        Validation postalCodeValidation  = postalCodeInstance.validate("32");
        Assertions.assertTrue(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeABInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("33");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeBCInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "BC");
        Validation postalCodeValidation  = postalCodeInstance.validate("34");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeMBInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "MB");
        Validation postalCodeValidation  = postalCodeInstance.validate("35");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNBInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "NB");
        Validation postalCodeValidation  = postalCodeInstance.validate("36");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNLInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "NL");
        Validation postalCodeValidation  = postalCodeInstance.validate("37");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNSInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "NS");
        Validation postalCodeValidation  = postalCodeInstance.validate("38");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNTInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "NT");
        Validation postalCodeValidation  = postalCodeInstance.validate("39");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeNUInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "NU");
        Validation postalCodeValidation  = postalCodeInstance.validate("40");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeONInvalid() {
        PostalCode postalCodeInstance = new PostalCode("A1A1A1", "ON");
        Validation postalCodeValidation  = postalCodeInstance.validate("41");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodePEInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "PE");
        Validation postalCodeValidation  = postalCodeInstance.validate("42");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeQCInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "QC");
        Validation postalCodeValidation  = postalCodeInstance.validate("43");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeSKInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "SK");
        Validation postalCodeValidation  = postalCodeInstance.validate("44");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeYTInvalid() {
        PostalCode postalCodeInstance = new PostalCode("K1A1A1", "YT");
        Validation postalCodeValidation  = postalCodeInstance.validate("45");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeDInvalid() {
        PostalCode postalCodeInstance = new PostalCode("D1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("46");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeFInvalid() {
        PostalCode postalCodeInstance = new PostalCode("F1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("47");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeIInvalid() {
        PostalCode postalCodeInstance = new PostalCode("I1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("48");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeOInvalid() {
        PostalCode postalCodeInstance = new PostalCode("O1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("49");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeQInvalid() {
        PostalCode postalCodeInstance = new PostalCode("Q1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("50");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeUInvalid() {
        PostalCode postalCodeInstance = new PostalCode("U1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("51");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeWInvalid() {
        PostalCode postalCodeInstance = new PostalCode("W1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("52");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidatePostalCodeZInvalid() {
        PostalCode postalCodeInstance = new PostalCode("Z1A1A1", "AB");
        Validation postalCodeValidation  = postalCodeInstance.validate("53");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }

    @Test
    public void testValidateCountryCodeInvalid() {
        PostalCode postalCodeInstance = new PostalCode("A1A1A1", "UT");
        Validation postalCodeValidation  = postalCodeInstance.validate("54");
        Assertions.assertFalse(postalCodeValidation.getMessage().contains("Valid."));
    }
}
