package utilities;

public enum ErrorMsgs {
    USERNAME_EMPTY("Username cannot be empty"),
    INVALID_CREDENTIALS("Invalid credentials"),
    NO_RECORDS_FOUND("No Records Found");

    private final String text;
    ErrorMsgs(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
