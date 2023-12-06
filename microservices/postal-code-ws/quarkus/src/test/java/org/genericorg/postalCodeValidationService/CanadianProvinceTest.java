package org.genericorg;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CanadianProvinceTest {
    
    @Test
    public void testHasValidProvinceCodeValidAB() {
        CanadianProvince province = new CanadianProvince("AB");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidBC() {
        CanadianProvince province = new CanadianProvince("BC");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidMB() {
        CanadianProvince province = new CanadianProvince("MB");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidNB() {
        CanadianProvince province = new CanadianProvince("NB");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidNL() {
        CanadianProvince province = new CanadianProvince("NL");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidNS() {
        CanadianProvince province = new CanadianProvince("NS");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidNT() {
        CanadianProvince province = new CanadianProvince("NT");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidNU() {
        CanadianProvince province = new CanadianProvince("NU");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidON() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidPE() {
        CanadianProvince province = new CanadianProvince("PE");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidQC() {
        CanadianProvince province = new CanadianProvince("QC");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidSK() {
        CanadianProvince province = new CanadianProvince("SK");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeValidYT() {
        CanadianProvince province = new CanadianProvince("YT");
        Assertions.assertTrue(province.hasValidProvinceCode());
    }
    
    @Test
    public void testHasValidProvinceCodeInvalid() {
        CanadianProvince province = new CanadianProvince("UT");
        Assertions.assertFalse(province.hasValidProvinceCode());
    }

    @Test
    public void testHasValidFirstLetterABValidT() {
        CanadianProvince province = new CanadianProvince("AB");
        Assertions.assertTrue(province.hasValidFirstLetter("T"));
    }

    @Test
    public void testHasValidFirstLetterABInvalid() {
        CanadianProvince province = new CanadianProvince("AB");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterBCValidV() {
        CanadianProvince province = new CanadianProvince("BC");
        Assertions.assertTrue(province.hasValidFirstLetter("V"));
    }

    @Test
    public void testHasValidFirstLetterBCInvalid() {
        CanadianProvince province = new CanadianProvince("BC");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterMBValidR() {
        CanadianProvince province = new CanadianProvince("MB");
        Assertions.assertTrue(province.hasValidFirstLetter("R"));
    }

    @Test
    public void testHasValidFirstLetterMBInvalid() {
        CanadianProvince province = new CanadianProvince("MB");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterNBValidE() {
        CanadianProvince province = new CanadianProvince("NB");
        Assertions.assertTrue(province.hasValidFirstLetter("E"));
    }

    @Test
    public void testHasValidFirstLetterNBInvalid() {
        CanadianProvince province = new CanadianProvince("NB");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterNLValidA() {
        CanadianProvince province = new CanadianProvince("NL");
        Assertions.assertTrue(province.hasValidFirstLetter("A"));
    }

    @Test
    public void testHasValidFirstLetterNLInvalid() {
        CanadianProvince province = new CanadianProvince("NL");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterNSValidB() {
        CanadianProvince province = new CanadianProvince("NS");
        Assertions.assertTrue(province.hasValidFirstLetter("B"));
    }

    @Test
    public void testHasValidFirstLetterNSInvalid() {
        CanadianProvince province = new CanadianProvince("NS");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterNTValidX() {
        CanadianProvince province = new CanadianProvince("NT");
        Assertions.assertTrue(province.hasValidFirstLetter("X"));
    }

    @Test
    public void testHasValidFirstLetterNTInvalid() {
        CanadianProvince province = new CanadianProvince("NT");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterNUValidX() {
        CanadianProvince province = new CanadianProvince("NU");
        Assertions.assertTrue(province.hasValidFirstLetter("X"));
    }

    @Test
    public void testHasValidFirstLetterNUInvalid() {
        CanadianProvince province = new CanadianProvince("NU");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterONValidK() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertTrue(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterONValidL() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertTrue(province.hasValidFirstLetter("L"));
    }

    @Test
    public void testHasValidFirstLetterONValidM() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertTrue(province.hasValidFirstLetter("M"));
    }

    @Test
    public void testHasValidFirstLetterONValidN() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertTrue(province.hasValidFirstLetter("N"));
    }

    @Test
    public void testHasValidFirstLetterONValidP() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertTrue(province.hasValidFirstLetter("P"));
    }

    @Test
    public void testHasValidFirstLetterONInvalid() {
        CanadianProvince province = new CanadianProvince("ON");
        Assertions.assertFalse(province.hasValidFirstLetter("A"));
    }

    @Test
    public void testHasValidFirstLetterPEValidC() {
        CanadianProvince province = new CanadianProvince("PE");
        Assertions.assertTrue(province.hasValidFirstLetter("C"));
    }

    @Test
    public void testHasValidFirstLetterPEInvalid() {
        CanadianProvince province = new CanadianProvince("PE");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterQCValidG() {
        CanadianProvince province = new CanadianProvince("QC");
        Assertions.assertTrue(province.hasValidFirstLetter("G"));
    }

    @Test
    public void testHasValidFirstLetterQCValidH() {
        CanadianProvince province = new CanadianProvince("QC");
        Assertions.assertTrue(province.hasValidFirstLetter("H"));
    }

    @Test
    public void testHasValidFirstLetterQCValidJ() {
        CanadianProvince province = new CanadianProvince("QC");
        Assertions.assertTrue(province.hasValidFirstLetter("J"));
    }

    @Test
    public void testHasValidFirstLetterQCInvalid() {
        CanadianProvince province = new CanadianProvince("QC");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterSKValidS() {
        CanadianProvince province = new CanadianProvince("SK");
        Assertions.assertTrue(province.hasValidFirstLetter("S"));
    }

    @Test
    public void testHasValidFirstLetterSKInvalid() {
        CanadianProvince province = new CanadianProvince("SK");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

    @Test
    public void testHasValidFirstLetterYTValidY() {
        CanadianProvince province = new CanadianProvince("YT");
        Assertions.assertTrue(province.hasValidFirstLetter("Y"));
    }

    @Test
    public void testHasValidFirstLetterYTInvalid() {
        CanadianProvince province = new CanadianProvince("YT");
        Assertions.assertFalse(province.hasValidFirstLetter("K"));
    }

}
