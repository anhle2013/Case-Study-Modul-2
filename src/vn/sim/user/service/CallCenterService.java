package vn.sim.user.service;

import vn.sim.modals.Card;
import vn.sim.modals.SimStatus;
import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.StaffService;

public class CallCenterService implements ICallCenterService {
    IStaffService staffService = new StaffService();
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
        int newMoney = staffService.getUserByPhoneNumber(phoneNumber).getMainAccount() + value;
        staffService.getUserByPhoneNumber(phoneNumber).setMainAccount(newMoney);
        return value;
    }

    @Override
    public int inputWrongCode(String phoneNumber) {
        int count = staffService.getUserByPhoneNumber(phoneNumber).getCountWrongCodeInput();
        staffService.getUserByPhoneNumber(phoneNumber).setCountWrongCodeInput(++count);
        if (count == 3)
            staffService.getUserByPhoneNumber(phoneNumber).setStatus(SimStatus.LOCKED);
        return count;
    }

}
