package vn.sim.staff.services;

import vn.sim.modals.Card;
import vn.sim.modals.SimUser;

import java.util.List;

public interface ICardService {
    Card depositToUser(SimUser user);
    List<String> getAllCards();
}
