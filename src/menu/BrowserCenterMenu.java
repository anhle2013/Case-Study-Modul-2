package menu;

import java.util.Scanner;

public class BrowserCenterMenu {
    public static void getBrowserCenter() {
        System.out.println();
        System.out.println("* * * * -- BROWSER CENTER -- * * * *");
        System.out.println("*                                  *");
        System.out.println("*     1. Search                    *");
        System.out.println("*     2. Watch video               *");
        System.out.println("*     3. Surf apps                 *");
        System.out.println("*     0. Return                    *");
        System.out.println("*                                  *");
        System.out.println("* * * * * * * * ** * * * * * * * * *");
    }
    public static void selectBrowserCenter() {
        getBrowserCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeclection action: ");
        System.out.print("⭆ ");
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                browser.action.Search.run();
                break;
            case 2:
                browser.action.WatchVideo.run();
                break;
            case 3:
                browser.action.SurfApps.run();
            case 0:
                menu.MainMenu.selectMainMenu();
                break;
            default:
                System.out.println("Action not found! Please try again");
                selectBrowserCenter();
                break;
        }
    }
}
