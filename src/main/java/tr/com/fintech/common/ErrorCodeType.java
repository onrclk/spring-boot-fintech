package tr.com.fintech.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCodeType {

    DO_NOT_HONOR("Do not honor"),
    INVALID_TRANSACTION("Invalid Transaction"),
    INVALID_CARD("Invalid Card"),
    NOT_SUFFICIENT_FUNDS("Not sufficient funds"),
    INCORRECT_PIN("Incorrect PIN"),
    INVALID_COUNTRY_ASSOCIATION("Invalid country association"),
    CURRENCY_NOT_ALLOWED("Currency not allowed"),
    _3D_SECURE_TRANSPORT_ERROR("3-D Secure Transport Error"),
    TRANSACTION_NOT_PERMITTED_CARDHOLDER("Transaction not permitted to cardholder");

    private String description;

    ErrorCodeType(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static ErrorCodeType fromValue(String val) {
        return Arrays.stream(values())
                .filter(errorCodeType -> errorCodeType.description.equals(val))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unsupported ErrorCode :" + val));
    }
}
