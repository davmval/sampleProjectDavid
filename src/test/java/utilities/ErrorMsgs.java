package utilities;

public enum ErrorMsgs {
    USERNAME_EMPTY("Username cannot be empty"),
    INVALID_CREDENTIALS("Invalid credentials");

    private final String text;

    ErrorMsgs(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
