package action.phone;

import java.io.IOException;

public class MainAccount {
    public static int mainAccount = 1000;
    public static void run() throws IOException {
        System.out.println("Main Account: " + mainAccount);
        menu.CallCenterMenu.selectCallCenter();
    }
}
