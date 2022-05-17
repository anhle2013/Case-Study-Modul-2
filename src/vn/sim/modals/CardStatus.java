package vn.sim.modals;

public enum CardStatus {
    NEW("NEW"),
    USED("USED");

    private final String value;

    CardStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static CardStatus getEnum(String value) {
        CardStatus[] values = values();
        for (CardStatus status : values) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new IllegalArgumentException("Invalid: " + value);
    }
}