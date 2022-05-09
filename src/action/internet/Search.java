package action.internet;

import menu.InternetCenterMenu;

import java.io.IOException;
import java.util.Scanner;

public class Search {
    public static void run() throws IOException {
        System.out.println("Search");

        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine()) ;

        InternetCenterMenu.selectInternetCenter();
    }
}
