//package vn.moblie.views.internet;
//
//import vn.moblie.views.menu.InternetCenterMenu;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class WatchVideo {
//    public static final int PRICE_WATCH_PER_TIME = 5000;
//
//    public static void run() throws IOException {
//        String key;
//        Scanner scanner = new Scanner(System.in);
//        if (vn.moblie.views.phone.MainAccount.mainAccount < PRICE_WATCH_PER_TIME) {
//            System.out.println("Not enough money to watch video, please deposit more!");
//            vn.moblie.views.menu.MainMenu.selectMainMenu();
//        }
//
//        System.out.print("Enter key to search: ");
//        key = scanner.nextLine();
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println("*                                     *");
//        System.out.println("*          WATCHING VIDEO             *");
//        System.out.println("*                                     *");
//        System.out.println("   " + key);
//        System.out.println("*                                     *");
//        System.out.println("*                                     *");
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println();
//
//        vn.moblie.views.phone.MainAccount.mainAccount -= PRICE_WATCH_PER_TIME;
//        vn.moblie.views.menu.MainMenu.selectMainMenu();
//    }
//}
