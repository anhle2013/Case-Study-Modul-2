package vn.sim.user.service;

public interface ICallCenterService {
    boolean checkCard(String code, String phoneNumber);
    int deposit(String phoneNumber, String code);
    int inputWrongCode(String phoneNumber);
}
