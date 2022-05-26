package vn.sim.user.service;

import vn.sim.modals.Card;
import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;
import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.StaffService;
import vn.sim.utils.AppUtils;
import vn.sim.utils.CSVUtils;

import java.util.List;

public class CallCenterService implements ICallCenterService {
    IStaffService staffService = new StaffService();
    private final static String PATH = "data/users.csv";
    public boolean checkCard(String code, String phoneNumber) {
        Card card = new Card();
        for (int i = 0; i < card.getCards().size(); i++) {
            if (card.getCards().get(i).equals(code)) {
                card.getUsedCard().put(code,phoneNumber);
                card.getCards().remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int deposit(String phoneNumber, String code) {
        int value = Integer.parseInt(code.substring(0,3) + "000");
        int mainAccount = AppUtils.getMainAccount(phoneNumber);
        AppUtils.setMainAccount(phoneNumber, mainAccount + value);
        return value;
    }

    @Override
    public int inputWrongCode(String phoneNumber) {
        List<SimUser> userList = staffService.getAll();
        int index = -1;
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getPhoneNumber().equals(phoneNumber))
                index = i;

        int count = userList.get(index).getCountWrongCodeInput();
        userList.get(index).setCountWrongCodeInput(++count);
        if (count % 3 == 0) {
            userList.get(index).setStatus(SimStatus.LOCKED);
            CSVUtils.write(PATH, userList);
            }
        return count;
    }

}
