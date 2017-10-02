package tr.com.fintech.config.exception;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private String message;

    private String description;

    public ErrorDTO(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
