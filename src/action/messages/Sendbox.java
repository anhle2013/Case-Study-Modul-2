package action.messages;

import menu.MessageCenterMenu;

import java.io.IOException;

public class Sendbox {
    public static void run() throws IOException {
        System.out.println("Sendbox");
        MessageCenterMenu.selectMessageCenter();
    }
}
