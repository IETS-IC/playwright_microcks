package org.genericorg;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ValidatorTest {

    @Test
    public void testNormalizePrecedingSpaces() {
        Assertions.assertEquals("UNITTEST", Validator.normalize(" UNITTEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNITTEST"));
    }

    @Test
    public void testNormalizeEmbeddedSpaces() {
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT TEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("U N I T T E S T"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("U   NIT  TES   T"));
    }

    @Test
    public void testNormalizeSucceedingSpaces() {
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNITTEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNITTEST  "));
    }

    @Test
    public void testNormalizeInterspersedSpaces() {
        Assertions.assertEquals("UNITTEST", Validator.normalize(" UNIT TEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNIT TEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNIT  TEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  U   NIT  TES   T"));
        Assertions.assertEquals("UNITTEST", Validator.normalize(" UNITTEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNITTEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize(" UNITTEST  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNITTEST  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT TEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT TEST  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT  TEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("U   NIT  TES   T "));
        Assertions.assertEquals("UNITTEST", Validator.normalize(" UNIT TEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNIT TEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNIT TEST  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNIT  TEST "));
        Assertions.assertEquals("UNITTEST", Validator.normalize(" UNIT  TEST  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  UNIT  TEST  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  U   NIT  TES    T  "));
        Assertions.assertEquals("UNITTEST", Validator.normalize("  U   N I T  T E S    T  "));
    }

    @Test
    public void testNormalizeAllLowercase() {
        Assertions.assertEquals("UNITTEST", Validator.normalize("unittest"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("Unittest"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("unitTest"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UnitTest"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("unittesT"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("uNiTtEsT"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNITTEST"));
        Assertions.assertEquals("UNIT0123456789TEST", Validator.normalize("unit0123456789test"));
    }

    @Test
    public void testNormalizeHyphenFiltering() {
        Assertions.assertEquals("UNITTEST", Validator.normalize("-UNITTEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNITTEST-"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT-TEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("U-N-I-T-T-E-S-T"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("-UNIT-TEST-"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT-TEST-"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("-U-N-I-T-T-E-S-T-"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("--UNITTEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNITTEST--"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("UNIT--TEST"));
        Assertions.assertEquals("UNITTEST", Validator.normalize("--U--N-I-T---T-E-S--T--"));
    }

    @Test
    public void testNormalize() {
        Assertions.assertEquals("UNIT7TEST", Validator.normalize(" uNiT 7 tEsT "));
        Assertions.assertEquals("UNIT7TEST", Validator.normalize(" - UNIT - 7 - TEST - "));
        Assertions.assertEquals("UNIT7TEST", Validator.normalize("-uNiT-7-tEsT-"));
        Assertions.assertEquals("UNIT7TEST", Validator.normalize("  -  - -- uN-iT --  7  -- tE sT -- -  - "));
    }

    @Test
    public void testMatchPattern() {
        Assertions.assertTrue(Validator.matchPattern("^\\d{9}$", "000000000"));
        Assertions.assertFalse(Validator.matchPattern("^\\d{9}$", "a000000000"));
        Assertions.assertFalse(Validator.matchPattern("^\\d{9}$", "000000000a"));
        Assertions.assertFalse(Validator.matchPattern("^\\d{9}$", "a000000000a"));
        Assertions.assertFalse(Validator.matchPattern("^\\d{9}$", "0000a00000"));
        Assertions.assertFalse(Validator.matchPattern("^\\d{9}$", "000-000-000"));
        Assertions.assertFalse(Validator.matchPattern("^\\d{9}$", "000 000 000"));

        Assertions.assertTrue(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "4222222222222"));
        Assertions.assertTrue(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "4111111111111111"));
        Assertions.assertFalse(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "a4111111111111111"));
        Assertions.assertFalse(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "4111111111111111a"));
        Assertions.assertFalse(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "a4111111111111111a"));
        Assertions.assertFalse(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "41111111a11111111"));
        Assertions.assertFalse(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "4111-1111-1111-1111"));
        Assertions.assertFalse(Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$", "4111 1111 1111 1111"));

        Assertions.assertTrue(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1A1A1"));
        Assertions.assertTrue(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1A 1A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "aA1A1A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1A1A1a"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "aA1A1A1a"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1Aa1A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1A-1A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "AAA1A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1AAA1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1A1AA"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "11A1A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A111A1"));
        Assertions.assertFalse(Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", "A1A111"));
    }

    @Test
    public void testLuhnAlgorithm() {
        Assertions.assertTrue(Validator.luhnAlgorithm("4222222222222"));
        Assertions.assertTrue(Validator.luhnAlgorithm("4111111111111111"));
        Assertions.assertFalse(Validator.luhnAlgorithm("4111111111111110"));
        Assertions.assertFalse(Validator.luhnAlgorithm("4111111111111112"));
    }

}
