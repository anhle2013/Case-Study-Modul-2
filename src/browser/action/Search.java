package browser.action;

import menu.BrowserCenterMenu;

import java.util.Scanner;

public class Search {
    public static void run() {
        System.out.println("Search");

        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine()) ;

        BrowserCenterMenu.selectBrowserCenter();
    }
}
