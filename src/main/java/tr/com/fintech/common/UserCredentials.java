package tr.com.fintech.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserCredentials implements Serializable {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
