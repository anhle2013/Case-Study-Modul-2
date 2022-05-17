package vn.sim.modals;

public enum SimStatus {
    ACTIVE("ACTIVE"),
    LOCKED("LOCKED"),
    DISABLED("DISABLED");

    private final String value;

    SimStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static SimStatus getEnum(String value) {
        SimStatus[] values = values();
        for (SimStatus simStatus : values) {
            if (simStatus.getValue().equals(value))
                return simStatus;
        }
        throw new IllegalArgumentException("Invalid: " + value);
    }
}
