package vn.sim.modals;

public class SimUser {
    private String serial;
    private String phoneNumber;
    private String password;
    private String personId;
    private String name;
    private int mainAccount = 1000;
    private PromotionAccount promotionAccount;
    private String email;
    private Role role;
    private SimStatus simStatus;

    public SimUser(String serial, String phoneNumber, String password) {
        this.serial = serial;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.simStatus = SimStatus.ACTIVE;
        this.role = Role.SIM_USER;
    }

    public SimUser(String serial, String phoneNumber, String password, String personId, String name, String email) {
        this.serial = serial;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.simStatus = SimStatus.ACTIVE;
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.role = Role.SIM_USER;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMainAccount() {
        return mainAccount;
    }

    public void setMainAccount(int mainAccount) {
        this.mainAccount = mainAccount;
    }

    public PromotionAccount getPromotionAccount() {
        return promotionAccount;
    }

    public void setPromotionAccount(PromotionAccount promotionAccount) {
        this.promotionAccount = promotionAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SimStatus getStatus() {
        return simStatus;
    }

    public void setStatus(SimStatus simStatus) {
        this.simStatus = simStatus;
    }
}
