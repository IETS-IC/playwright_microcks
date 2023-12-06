package org.genericorg;

public class Validation {
    private String id;
    private boolean valid;
    private String message;

    public Validation(String id, boolean valid, String message) {
        this.id = id;
        this.valid = valid;
        this.message = message;
    }

    public String getID() {
        return this.id;
    }

    public boolean getValid() {
        return this.valid;
    }

    public String getMessage() {
        return this.message;
    }
}
