package vn.sim.modals;

public class Staff {
    private String user;
    private String password;

    public Staff() {
        user = "staff";
        password = "staff123!";
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String staffLogin(String user, String password) {
        if (getUser().equals(user) && getPassword().equals(password))
            return user;
        return null;
    }
}
