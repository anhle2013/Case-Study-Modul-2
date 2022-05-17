package vn.sim.staff.services;

import vn.sim.modals.SimUser;
import java.util.List;

public interface IStaffService {
    boolean existSerial(String serial);
    boolean existPhoneNumber(String phoneNumber);
    boolean existPersonId(String personId);
    boolean existEmail(String email);
    List<SimUser> findAll();
    List<SimUser> findUsers(String key);
    void addUser(SimUser user);
    SimUser getUser(String personId);
    void reActiveSim(String personId);
    void changeSim(String personId, String newSeri);
    void depositSimAccount(String personId, int money);
    int getIndex(String personId);
}
