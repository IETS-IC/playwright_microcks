package org.genericorg;

public class PostalCode {
    private String postalCode;
    private CanadianProvince province;

    public PostalCode(String postalCode, String provinceCode) {
        this.postalCode = Validator.normalize(postalCode);
        this.province = new CanadianProvince(Validator.normalize(provinceCode));
    }

    public Validation validate(String id) {
        // Check 1: Determine whether Province code is valid
        if (!this.province.hasValidProvinceCode()) {
            return new Validation(id, false, this.province.getErrorMessage());
        }

        // Check 2: Postal code must be in the pattern of A1A 1A1 or A1A1A1
        if (!Validator.matchPattern("^[A-Z]\\d[A-Z] ?\\d[A-Z]\\d$", this.postalCode)) {
            return new Validation(id, false, "[Postal Code Validation] Postal code does not match pattern A1A 1A1 or A1A1A1.");
        }

        // Check 3: Postal codes cannot contain the ltters D, F, I, O, Q, or U, and cannot start with W or Z.
        if (!Validator.matchPattern("^[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ] ?[0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]$", this.postalCode)) {
            return new Validation(id, false, "[Postal Code Validation] Postal codes cannot contain the letters D, F, I, O, Q, or U, and cannot start with W or Z.");
        }

        // Check 4: If province is given, the first letter of the postal code must match its province
        if (!this.province.hasValidFirstLetter(this.postalCode.substring(0, 1))) {
            return new Validation(id, false, this.province.getErrorMessage());
        }

        // If all checks pass, return validity state
        return new Validation(id, true, "[Postal Code Validation] Valid.");
    }
}
