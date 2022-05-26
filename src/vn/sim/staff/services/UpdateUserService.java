package vn.sim.staff.services;

import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;
import vn.sim.utils.CSVUtils;

import java.util.List;

public class UpdateUserService implements IUpdateUserService{
    IStaffService staffService = new StaffService();
    private final static String PATH = "data/users.csv";

    @Override
    public void changeSerial(SimUser user, String newSerial) {
        user.setSerial(newSerial);
    }

    @Override
    public void changePhoneNumber(SimUser user, String newPhoneNumber) {
        user.setPhoneNumber(newPhoneNumber);
    }

    @Override
    public void updatePersonId(SimUser user, String newPersonId) {
        user.setPersonId(newPersonId);
    }

    @Override
    public void updateName(SimUser user, String newName) {
        user.setName(newName);
    }

    @Override
    public void updateEmail(SimUser user, String newEmail) {
        user.setEmail(newEmail);
    }

    @Override
    public void changeSimStatus(SimUser user, SimStatus newSimStatus) {
        user.setStatus(newSimStatus);
    }
}
