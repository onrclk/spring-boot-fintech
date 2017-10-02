package tr.com.fintech.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

//@JsonDeserialize(using = OperationTypeDeserializer.class)
public enum OperationType {

    _DIRECT("DIRECT"), REFUND("REFUND"), _3D("3D"), _3DAUTH("3DAUTH"), _STORED("STORED");

    private String name;

    OperationType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static OperationType forValue(String value) {
        return Arrays.stream(values())
                .filter(operationType -> operationType.name.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unsupported type found :" + value));
    }
}
