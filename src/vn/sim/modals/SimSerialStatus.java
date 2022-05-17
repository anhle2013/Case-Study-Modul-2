package vn.sim.modals;

public enum SimSerialStatus {
    NEW("NEW"),
    USING("USING"),
    DISABLED("DISABLED");

    private final String value;

    SimSerialStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static SimSerialStatus getEnum(String value) {
        SimSerialStatus[] values = values();
        for (SimSerialStatus status : values) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new IllegalArgumentException("Invalid: " + value);
    }
}