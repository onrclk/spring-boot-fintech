package tr.com.fintech.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FilterFieldType {

    TRANSACTION_UUID("Transaction   UUID"),
    CUSTOMER_EMAIL("Customer   Email"),
    REFERENCE_NO("Reference   No"),
    CUSTOM_DATA("Custom   Data"),
    CARD_PAN("Card   PAN");

    private String description;

    FilterFieldType(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static FilterFieldType fromValue(String value) {
        return Arrays.stream(values())
                .filter(filterFieldType -> filterFieldType.description.equalsIgnoreCase(value))
                .findFirst().orElseThrow(() -> new IllegalStateException("Unsupported FilterType : " + value));
    }
}
