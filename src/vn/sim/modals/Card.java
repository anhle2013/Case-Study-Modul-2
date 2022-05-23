package vn.sim.modals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
    private static List<String> cards;
    private static HashMap<String, String> usedCard = new HashMap<>();
    static {
        cards = new ArrayList<>();
        cards.add("010X2022X123456");
        cards.add("010X2022X123455");
        cards.add("010X2022X123454");
        cards.add("010X2022X123453");
        cards.add("010X2022X123452");
        cards.add("010X2022X123451");

        cards.add("020X2022X123456");
        cards.add("020X2022X123455");
        cards.add("020X2022X123454");
        cards.add("020X2022X123453");
        cards.add("020X2022X123452");
        cards.add("020X2022X123451");

        cards.add("050X2022X123456");
        cards.add("050X2022X123455");
        cards.add("050X2022X123454");
        cards.add("050X2022X123453");
        cards.add("050X2022X123452");
        cards.add("050X2022X123451");

        cards.add("100X2022X123456");
        cards.add("100X2022X123455");
        cards.add("100X2022X123454");
        cards.add("100X2022X123453");
        cards.add("100X2022X123452");
        cards.add("100X2022X123451");
    }

    public List<String> getCards() {
        return cards;
    }

    public HashMap<String, String> getUsedCard() {
        return usedCard;
    }

}

