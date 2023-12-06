package org.genericorg;

import java.util.Arrays;
import java.util.HashMap;

public class CanadianProvince {
    private String provinceCode;
    private String[] validFirstLetters;

    public static HashMap<String, String[]> ProvinceIdentityEnum;
    static {
        ProvinceIdentityEnum = new HashMap<String, String[]>();
        ProvinceIdentityEnum.put("AB", new String[] {"T"});
        ProvinceIdentityEnum.put("BC", new String[] {"V"});
        ProvinceIdentityEnum.put("MB", new String[] {"R"});
        ProvinceIdentityEnum.put("NB", new String[] {"E"});
        ProvinceIdentityEnum.put("NL", new String[] {"A"});
        ProvinceIdentityEnum.put("NS", new String[] {"B"});
        ProvinceIdentityEnum.put("NT", new String[] {"X"});
        ProvinceIdentityEnum.put("NU", new String[] {"X"});
        ProvinceIdentityEnum.put("ON", new String[] {"K", "L", "M", "N", "P"});
        ProvinceIdentityEnum.put("PE", new String[] {"C"});
        ProvinceIdentityEnum.put("QC", new String[] {"G", "H", "J"});
        ProvinceIdentityEnum.put("SK", new String[] {"S"});
        ProvinceIdentityEnum.put("YT", new String[] {"Y"});
    }

    public static HashMap<String, String> ProvinceNameEnum;
    static {
        ProvinceNameEnum = new HashMap<String, String>();
        ProvinceNameEnum.put("AB", "Alberta");
        ProvinceNameEnum.put("BC", "British Columbia");
        ProvinceNameEnum.put("MB", "Manitoba");
        ProvinceNameEnum.put("NB", "New Brunswick");
        ProvinceNameEnum.put("NL", "Newfoundland & Labrador");
        ProvinceNameEnum.put("NS", "Nova Scotia");
        ProvinceNameEnum.put("NT", "Northwest Territories");
        ProvinceNameEnum.put("NU", "Nunavut");
        ProvinceNameEnum.put("ON", "Ontario");
        ProvinceNameEnum.put("PE", "Prince Edward Island");
        ProvinceNameEnum.put("QC", "Quebec");
        ProvinceNameEnum.put("SK", "Saskatchewan");
        ProvinceNameEnum.put("YT", "Yukon");
    }

    public CanadianProvince(String provinceCode) {
        this.provinceCode = provinceCode;
        this.validFirstLetters = new String[] {};
        if (provinceCode != "") {
            String[] letters = CanadianProvince.ProvinceIdentityEnum.get(this.provinceCode);
            if (letters != null) {
                this.validFirstLetters = letters;
            }
        }
    }

    public boolean hasValidProvinceCode() {
        return this.validFirstLetters.length > 0;
    }

    public boolean hasValidFirstLetter(String firstLetter) {
        return Arrays.stream(this.validFirstLetters).anyMatch((String letter) -> {
            return firstLetter.equals(letter);
        });
    }

    public String getErrorMessage() {
        if (this.validFirstLetters.length < 1) {
            return String.format("[Postal Code Validation] Province %s is invalid.", this.provinceCode);
        } else {
            return String.format("[Postal Code Validation] A postal code from the province of %s must start with one of %s.",
                CanadianProvince.ProvinceNameEnum.get(this.provinceCode),
                String.join(", ", this.validFirstLetters));
        }
    }
}
