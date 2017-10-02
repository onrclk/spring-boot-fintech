package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Ipn implements Serializable {

    @JsonProperty("received")
    private Boolean received;
}
