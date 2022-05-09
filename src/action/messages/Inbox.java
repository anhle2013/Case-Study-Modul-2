package action.messages;

import menu.MessageCenterMenu;

import java.io.IOException;

public class Inbox {
    public static void run() throws IOException {
        System.out.println("Inbox");
        MessageCenterMenu.selectMessageCenter();
    }
}
