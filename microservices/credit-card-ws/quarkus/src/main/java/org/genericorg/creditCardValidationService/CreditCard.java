package org.genericorg;

public class CreditCard {
    private String creditCardNumber;

    public CreditCard(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Validation validate() {
        return this.validate("-1");
    }

    public Validation validate(String id) {
        if (!Validator.matchPattern("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|"
            + "(?<mastercard>5[1-5][0-9]{14})|"
            + "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|"
            + "(?<amex>3[47][0-9]{13})|"
            + "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|"
            + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$", this.creditCardNumber)) {
            return new Validation(id, false, "[Credit Card Validation] Failed number validation.");
        }

        if (!Validator.luhnAlgorithm(this.creditCardNumber)) {
            return new Validation(id, false, "[Credit Card Validation] Failed checksum.");
        }

        return new Validation(id, true, "[Credit Card Validation] Valid.");
    }
}
