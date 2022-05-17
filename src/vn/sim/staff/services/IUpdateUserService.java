package vn.sim.staff.services;

import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;

public interface IUpdateUserService {

    void changeSerial(SimUser user, String newSerial);
    void changePhoneNumber(SimUser user, String newPhoneNumber);
    void updatePersonId(SimUser user, String newPersonId);
    void updateName(SimUser user, String newName);
    void updateEmail(SimUser user, String newEmail);
    void changeSimStatus(SimUser user, SimStatus newSimStatus);
}
