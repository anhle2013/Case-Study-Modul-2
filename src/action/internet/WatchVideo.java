package action.internet;

import menu.InternetCenterMenu;

import java.io.IOException;

public class WatchVideo {
    public static void run() throws IOException {
        System.out.println("Watch video");
        InternetCenterMenu.selectInternetCenter();
    }
}
