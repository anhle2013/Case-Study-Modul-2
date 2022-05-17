//package vn.moblie.views.internet;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Search {
//    public static final int PRICE_SEARCH_PER_TIME = 500;
//
//    public static void run() throws IOException {
//        String key;
//        Scanner scanner = new Scanner(System.in);
//        if (vn.moblie.views.phone.MainAccount.mainAccount < PRICE_SEARCH_PER_TIME) {
//        System.out.println("Not enough money to search, please deposit more!");
//        vn.moblie.views.menu.MainMenu.selectMainMenu();
//        }
//
//        System.out.print("Enter key to search: ");
//        key = scanner.nextLine();
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println("*                                     *");
//        System.out.println("*             SEARCHING               *");
//        System.out.println("*                                     *");
//        System.out.println("   " + key + " is: ........");
//        System.out.println("*                                     *");
//        System.out.println("*                                     *");
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println();
//
//        vn.moblie.views.phone.MainAccount.mainAccount -= PRICE_SEARCH_PER_TIME;
//        vn.moblie.views.menu.MainMenu.selectMainMenu();
//    }
//}
