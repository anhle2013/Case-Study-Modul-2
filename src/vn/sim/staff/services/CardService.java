package vn.sim.staff.services;

import vn.sim.modals.Card;
import vn.sim.modals.SimUser;
import vn.sim.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class CardService implements ICardService {
    static List<String> cards = new ArrayList<>();
    public final static String PATH = "data/cards.csv";

    public CardService() {}

    @Override
    public List<String> getAllCards() {
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            cards.add(record);
        }
        return cards;
    }
    @Override
    public Card depositToUser(SimUser user) {
        return null;
    }
}
