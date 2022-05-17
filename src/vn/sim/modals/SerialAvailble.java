package vn.sim.modals;

import java.util.HashMap;
import java.util.HashSet;

public class SerialAvailble {
    private HashMap<String,SimSerialStatus> simList;
    public SerialAvailble() {
        simList = new HashMap();
        simList.put("190 570 568 980", SimSerialStatus.NEW);
        simList.put("190 570 568 880", SimSerialStatus.NEW);
        simList.put("190 570 568 780", SimSerialStatus.NEW);
        simList.put("190 570 568 680", SimSerialStatus.NEW);
        simList.put("190 570 568 580", SimSerialStatus.NEW);
        simList.put("190 570 568 480", SimSerialStatus.NEW);
        simList.put("190 570 568 380", SimSerialStatus.NEW);
        simList.put("190 570 568 280", SimSerialStatus.NEW);
        simList.put("190 570 568 180", SimSerialStatus.NEW);
        simList.put("190 570 568 080", SimSerialStatus.NEW);
    }
}
