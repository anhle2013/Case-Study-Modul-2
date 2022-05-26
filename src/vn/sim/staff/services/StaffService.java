package vn.sim.staff.services;

import vn.sim.modals.Role;
import vn.sim.modals.SimUser;
import vn.sim.modals.SimStatus;
import vn.sim.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffService implements IStaffService {

    private final static String PATH = "data/users.csv";
    public static List<SimUser> userList;

    //List<SimUser> simListDisable;
    public StaffService() {
    }

    @Override
    public boolean existSerial(String serial) {
        userList = getAll();
        for (SimUser user : userList)
            if (user.getSerial().equals(serial))
                return true;
        return false;
    }

    @Override
    public boolean existPhoneNumber(String phoneNumber) {
        userList = getAll();
        for (SimUser user : userList)
            if (user.getPhoneNumber().equals(phoneNumber))
                return true;
        return false;
    }

    @Override
    public boolean existPersonId(String personId) {
        userList = getAll();
        for (SimUser user : userList)
            if (user.getPersonId().equals(personId))
                return true;
        return false;
    }

    @Override
    public boolean existEmail(String email) {
        userList = getAll();
        for (SimUser user : userList)
            if (user.getEmail().equals(email))
                return true;
        return false;
    }

    @Override
    public List<SimUser> getAll() {
        userList = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            userList.add(SimUser.parseUser(record));
        }
        return userList;
    }

    @Override
    public List<SimUser> findUsers(String key) {
        List<SimUser> users = getAll();
        for (SimUser user : users)
            if (user.getPhoneNumber().contains(key) || user.getPersonId().contains(key))
                users.add(user);
        return users;
    }

    @Override
    public void addUser(SimUser user) {
        userList = getAll();
        userList.add(user);
        CSVUtils.write(PATH, userList);
    }

    @Override
    public SimUser getUser(String personId) {
        userList = getAll();
        for (SimUser user : userList)
            if (user.getPersonId().equals(personId))
                return user;
        return null;
    }

    @Override
    public SimUser getUserByPhoneNumber(String phoneNumber) {
        userList = getAll();
        for (SimUser user : userList)
            if (user.getPhoneNumber().equals(phoneNumber))
                return user;
        return null;
    }

    @Override
    public void reActiveSim(String personId) {
        userList = getAll();
        int index = getIndex(personId);
        userList.get(index).setStatus(SimStatus.getEnum("ACTIVE"));
    }

    @Override
    public void changeSim(String personId, String newSerial) {
        userList = getAll();
        int index = getIndex(personId);
        userList.get(index).setSerial(newSerial);
    }

    @Override
    public void depositSimAccount(String personId, int money) {
        userList = getAll();
        int index = getIndex(personId);
        int mainAccount = userList.get(index).getMainAccount();
        userList.get(index).setMainAccount(mainAccount + money);

    }

    @Override
    public int getIndex(String personId) {
        userList = getAll();
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getPersonId().equals(personId))
                return i;
        return -1;
    }

    public String userLogin(String user, String password) {
        userList = getAll();
        for (SimUser simUser : userList) {
            if (simUser.getPhoneNumber().equals(user) && simUser.getPassword().equals(password)
                    && simUser.getRole().equals(Role.SIM_USER)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateCSV(SimUser newUser) {
        userList = getAll();
        for (SimUser user : userList) {
            if (user.getPhoneNumber().equals(newUser.getPhoneNumber())) {
                String serial = newUser.getSerial();
                if (serial != null)
                    user.setSerial(serial);
                String personId = newUser.getPersonId();
                if (personId != null)
                    user.setPersonId(personId);
                String name = newUser.getName();
                if (name != null)
                    user.setName(name);
                String email = newUser.getEmail();
                if (email != null)
                    user.setEmail(email);
                SimStatus status = newUser.getStatus();
                if (status != null)
                    user.setStatus(status);
                break;
            }
        }
        CSVUtils.write(PATH, userList);
    }

}
