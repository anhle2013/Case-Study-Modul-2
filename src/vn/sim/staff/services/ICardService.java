package vn.sim.staff.services;

import vn.sim.modals.Card;
import vn.sim.modals.SimUser;

public interface ICardService {
    Card depositToUser(SimUser user);
}
