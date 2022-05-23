package vn.sim.user.service;

import vn.sim.modals.Message;
import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.StaffService;

import java.time.Instant;
import java.util.ArrayList;

public class MessageCenterService implements IMessageCenterService {
    IStaffService staffService = new StaffService();

    @Override
    public void saveDraft(String phoneNumber, String message) {
        Instant time = Instant.now();
        staffService.getUserByPhoneNumber(phoneNumber).addDrafts(new Message(time,message));
    }

    @Override
    public void sendMessage(String phoneNumber, String toPhoneNumber, String message) {
        Instant time = Instant.now();
        staffService.getUserByPhoneNumber(phoneNumber).addSendbox(new Message(phoneNumber,toPhoneNumber,time,message));
        staffService.getUserByPhoneNumber(toPhoneNumber).addInbox(new Message(phoneNumber,toPhoneNumber,time,message));
    }

    @Override
    public ArrayList<Message> getDrafts(String phoneNumber) {
        return staffService.getUserByPhoneNumber(phoneNumber).getDrafts();
    }

    @Override
    public ArrayList<Message> getSendbox(String phoneNumber) {
        return staffService.getUserByPhoneNumber(phoneNumber).getSendbox();
    }

    @Override
    public ArrayList<Message> getInbox(String phoneNumber) {
        return staffService.getUserByPhoneNumber(phoneNumber).getInbox();
    }
}
