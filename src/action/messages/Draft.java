package action.messages;

import menu.MessageCenterMenu;

import java.io.IOException;

public class Draft {
    public static void run() throws IOException {
        System.out.println("Draft");
        MessageCenterMenu.selectMessageCenter();
    }
}
