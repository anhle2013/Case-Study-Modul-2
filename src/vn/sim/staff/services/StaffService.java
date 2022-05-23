package vn.sim.staff.services;

import vn.sim.modals.Role;
import vn.sim.modals.SimUser;
import vn.sim.modals.SimStatus;

import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaffService {
    static List<SimUser> userList = new ArrayList<>();
    //List<SimUser> simListDisable;
    public StaffService() {}
    static {
        userList.add(new SimUser("190.570.568.680","0968686868","abc123!",
                "192564542", "Phan Nhat", "nhatphan99@gmail.com"));
        userList.add(new SimUser("190.570.668.680","0988888888","abc123!",
                "201125454", "Nguyen Minh Tri", "tri.nguyen20@gmail.com"));
        userList.add(new SimUser("190.570.768.680","0900000001","abc123!",
                "202564876", "Phan Nhat Thanh", "nhatthanh.20@gmail.com"));
        userList.add(new SimUser("190.570.868.680","0965432168","abc123!",
                "043392564542", "Pham My Hanh", "hanhmy.199@gmail.com"));
        userList.add(new SimUser("190.570.968.680","0987654321","abc123!",
                "194564548", "Bui Minh Thanh", "minhthanh.220@gmail.com"));
        userList.add(new SimUser("190.570.068.680","0965414617","abc123!",
                "199864542", "Tran Thi Le", "tranle.2320@gmail.com"));
        userList.add(new SimUser("190.570.168.680","0909876261","abc123!",
                "040969256542", "Pham Nhat Vuong", "nhatv.1010@gmail.com.vn"));
        userList.add(new SimUser("190.570.268.680","0902011922","abc123!",
                "042192564542", "Le Nhat Nhat", "nhatnha.2000@gmail.com"));
    }

    @Override
    public boolean existSerial(String serial) {
        for (SimUser user: userList)
            if (user.getSerial().equals(serial))
                return true;
        return false;
    }

    @Override
    public boolean existPhoneNumber(String phoneNumber) {
        for (SimUser user: userList)
            if (user.getPhoneNumber().equals(phoneNumber))
                return true;
        return false;
    }

    @Override
    public boolean existPersonId(String personId) {
        for (SimUser user: userList)
            if (user.getPersonId().equals(personId))
                return true;
        return false;
    }

    @Override
    public boolean existEmail(String email) {
        for (SimUser user: userList)
            if (user.getEmail().equals(email))
                return true;
        return false;
    }

    @Override
    public List<SimUser> findAll() {
        return userList;
    }

    @Override
    public List<SimUser> findUsers(String key) {
        List<SimUser> users = new ArrayList<>();
        for (SimUser user: userList)
            if (user.getPhoneNumber().contains(key) || user.getPersonId().contains(key))
                users.add(user);
        return users;
    }

    @Override
    public void addUser(SimUser user) {
        userList.add(user);
    }

    @Override
    public SimUser getUser(String personId) {
        for (SimUser user: userList)
            if (user.getPersonId().equals(personId))
                return user;
        return null;
    }

    @Override
    public SimUser getUserByPhoneNumber(String phoneNumber) {
        for (SimUser user: userList)
            if (user.getPhoneNumber().equals(phoneNumber))
                return user;
        return null;
    }

    @Override
    public void reActiveSim(String personId) {
        int index = getIndex(personId);
        userList.get(index).setStatus(SimStatus.getEnum("ACTIVE"));
    }

    @Override
    public void changeSim(String personId, String newSerial) {
        int index = getIndex(personId);
        userList.get(index).setSerial(newSerial);
    }

    @Override
    public void depositSimAccount(String personId, int money) {
        int index = getIndex(personId);
        int mainAccount = userList.get(index).getMainAccount();
        userList.get(index).setMainAccount(mainAccount + money);

    }

    @Override
    public int getIndex(String personId) {
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getPersonId().equals(personId))
                return i;
        return -1;
    }
    public String userLogin(String user, String password) {
        for (SimUser simUser : userList) {
            if (simUser.getPhoneNumber().equals(user) && simUser.getPassword().equals(password)
                    && simUser.getRole().equals(Role.SIM_USER)) {
                return user;
            }
        }
        return null;
    }

}
