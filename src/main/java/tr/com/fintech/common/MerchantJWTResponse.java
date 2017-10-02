package tr.com.fintech.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MerchantJWTResponse implements Serializable {

    @JsonProperty(value = "token", required = true)
    private String token;

    @JsonProperty(value = "status", required = true)
    private StatusType status;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
