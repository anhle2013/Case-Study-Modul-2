package vn.sim.modals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Card {
//    private List<String> card10s;
//    private List<String> card20s;
//    private List<String> card50s;
//    private List<String> card100s;
//    public Card() {
//        card10s = new ArrayList<>();
//            card10s.add("010X2022X123456");
//            card10s.add("010X2022X123455");
//            card10s.add("010X2022X123454");
//            card10s.add("010X2022X123453");
//            card10s.add("010X2022X123452");
//            card10s.add("010X2022X123451");
//        card20s =new ArrayList<>();
//            card20s.add("020X2022X123456");
//            card20s.add("020X2022X123455");
//            card20s.add("020X2022X123454");
//            card20s.add("020X2022X123453");
//            card20s.add("020X2022X123452");
//            card20s.add("020X2022X123451");
//        card50s = new ArrayList<>();
//            card50s.add("050X2022X123456");
//            card50s.add("050X2022X123455");
//            card50s.add("050X2022X123454");
//            card50s.add("050X2022X123453");
//            card50s.add("050X2022X123452");
//            card50s.add("050X2022X123451");
//        card100s =new ArrayList<>();
//            card100s.add("100X2022X123456");
//            card100s.add("100X2022X123455");
//            card100s.add("100X2022X123454");
//            card100s.add("100X2022X123453");
//            card100s.add("100X2022X123452");
//            card100s.add("100X2022X123451");
//
//    }
//
//    public String getCard10() {
//        return card10s.get(card10s.size()-1);
//    }
//    public void addCard10(String newCard) {
//        card10s.add(newCard);
//    }
//    public String getCard20() {
//        return card20s.get(card20s.size()-1);
//    }
//    public void addCard20(String newCard) {
//        card20s.add(newCard);
//    }
//    public String getCard50() {
//        return card50s.get(card50s.size()-1);
//    }
//    public void addCard50(String newCard) {
//        card50s.add(newCard);
//    }
//    public String getCard100() {
//        return card100s.get(card100s.size()-1);
//    }
//    public void addCard100(String newCard) {
//        card100s.add(newCard);
//    }
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
    private static List<String> cards;
    private static HashMap<String, CardStatus> listCard;
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

        listCard = new HashMap<>();
    }
}