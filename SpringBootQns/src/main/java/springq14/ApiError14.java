package springq14;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError14 {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> details;

    public ApiError14(int status, String error, List<String> details) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.details = details;
    }

    // getters
    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public List<String> getDetails() { return details; }
}
