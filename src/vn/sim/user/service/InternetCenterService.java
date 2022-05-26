package vn.sim.user.service;

import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.StaffService;

public class InternetCenterService implements IInternetService {
    IStaffService staffService = new StaffService();

}
