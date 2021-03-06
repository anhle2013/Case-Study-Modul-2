package vn.sim.modals;

import java.time.Instant;
import java.util.ArrayList;

public class SimUser {
    private String serial;
    private String phoneNumber;
    private String password;
    private String personId;
    private String name;
    private int mainAccount = 1000;
    private int countWrongCodeInput;
    private PromotionAccount promotionAccount;
    private String email;
    private Role role;
    private SimStatus simStatus;
    private ArrayList<Message> drafts = new ArrayList<>();
    private ArrayList<Message> inbox = new ArrayList<>();
    private ArrayList<Message> sendbox = new ArrayList<>();

    public SimUser() {}
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

    public SimUser(String serial, String phoneNumber, String password, String personId, String name, int mainAccount, int countWrongCodeInput, String email, SimStatus simStatus) {
        this(serial,phoneNumber,password,personId,name,email);
        this.mainAccount = mainAccount;
        this.countWrongCodeInput = countWrongCodeInput;
        this.simStatus = simStatus;
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

    public int getCountWrongCodeInput() {
        return countWrongCodeInput;
    }

    public void setCountWrongCodeInput(int countWrongCodeInput) {
        this.countWrongCodeInput = countWrongCodeInput;
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

    public ArrayList<Message> getDrafts() {
        return drafts;
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public ArrayList<Message> getSendbox() {
        return sendbox;
    }

    public void addDrafts(Message message) {
        drafts.add(message);
    }

    public void addInbox(Message message) {
        inbox.add(message);
    }

    public void addSendbox(Message message) {
        sendbox.add(message);
    }

    public static SimUser parseUser(String record) {
        String[] fields = record.split(",");
        String serial = fields[0];
        String phoneNumber = fields[1];
        String password = fields[2];
        String personId = fields[3];
        String name = fields[4];
        int mainAccount = Integer.parseInt(fields[5]);
        int countWrongCodeInput = Integer.parseInt(fields[6]);
        String email = fields[7];
        SimStatus simStatus = SimStatus.valueOf(fields[8]);

        return new SimUser(serial,phoneNumber,password,personId,name,mainAccount,countWrongCodeInput,email,simStatus);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                serial,phoneNumber,password,personId,name,mainAccount,countWrongCodeInput,email,simStatus);
    }
}
