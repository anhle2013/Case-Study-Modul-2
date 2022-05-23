package vn.sim.user.service;

import vn.sim.modals.Message;

import java.util.ArrayList;

public interface IMessageCenterService {
    void saveDraft(String phoneNumber, String message);
    void sendMessage(String phoneNumber, String toPhoneNumber, String message);
    ArrayList<Message> getDrafts(String phoneNumber);
    ArrayList<Message> getSendbox(String phoneNumber);
    ArrayList<Message> getInbox(String phoneNumber);
}
