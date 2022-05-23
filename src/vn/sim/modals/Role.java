package vn.sim.modals;

public enum Role {
    STAFF("STAFF"),
    SIM_USER("SIM USER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Role getEnum(String value) {
        Role[] values = values();
        for (Role role : values) {
            if (role.getValue().equals(value))
                return role;
        }
        throw new IllegalArgumentException("Invalid: " + value);
    }

}
