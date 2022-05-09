package menu;

import action.internet.Search;
import action.internet.SurfApps;
import action.internet.WatchVideo;

import java.io.IOException;
import java.util.Scanner;

public class InternetCenterMenu {
    public static void getInternetCenter() {
        System.out.println();
        System.out.println("* * * * -- INTERNET CENTER -- * * * *");
        System.out.println("*                                   *");
        System.out.println("*     1. Search                     *");
        System.out.println("*     2. Watch video                *");
        System.out.println("*     3. Surf apps                  *");
        System.out.println("*     0. Return                     *");
        System.out.println("*                                   *");
        System.out.println("* * * * * * * * * * * * * * * * * * *");
    }
    public static void selectInternetCenter() throws IOException {
        getInternetCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeclection action: ");
        System.out.print("⭆ ");
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                Search.run();
                break;
            case 2:
                WatchVideo.run();
                break;
            case 3:
                SurfApps.run();
            case 0:
                menu.MainMenu.selectMainMenu();
                break;
            default:
                System.out.println("Action not found! Please try again");
                selectInternetCenter();
                break;
        }
    }
}
