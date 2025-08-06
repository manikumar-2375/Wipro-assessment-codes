package springq13;

public class ErrorResponse13 {
    private String errorMessage;

    public ErrorResponse13(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
