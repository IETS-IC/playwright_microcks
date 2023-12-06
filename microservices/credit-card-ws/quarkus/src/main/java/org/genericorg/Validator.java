package org.genericorg;

public class Validator {
    public static String normalize(String value) {
        value = value.toUpperCase();
        value = value.trim();
        value = value.replaceAll("[ -]", "");
        return value;
    }

    public static boolean matchPattern(String regex, String value) {
        return value.matches(regex);
    }

    public static boolean luhnAlgorithm(String ccNumber) {
        try {
            // Building digits Array
            int ccnLength = ccNumber.length();
            int[] digits = new int[ccnLength];
            for (int i = 0; i < ccnLength; i++) {
                digits[i] = Integer.parseInt(ccNumber.substring(i, i+1));
                if ((i % 2) == (ccnLength % 2)) {
                    digits[i] *= 2;
                    if (digits[i] > 9) {
                        digits[i] = (digits[i] / 10) + digits[i] % 10;
                    }
                }
            }

            // Building sum
            int sum = 0;
            for (int digit: digits) {
                sum += digit;
            }
            return (sum % 10 == 0);
        } catch (Exception err) {
            return false;
        }
    }
}
