//package vn.moblie.views.internet;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class SurfApps {
//    public static final int PRICE_SURF_APPS_PER_SEC = 200;
//
//    public static void run() throws IOException {
//
//
//        String key;
//        long start, end;
//        int sec;
//        int secAvailable = vn.moblie.views.phone.MainAccount.mainAccount / PRICE_SURF_APPS_PER_SEC;
//        Scanner scanner = new Scanner(System.in);
//        if (secAvailable <= 0) {
//            System.out.println("Not enough money to surf app, please deposit more!");
//            vn.moblie.views.menu.MainMenu.selectMainMenu();
//        }
//
//        System.out.print("Enter app to surf: ");
//        key = scanner.nextLine();
//        int num = key.length();
//        start = System.currentTimeMillis();
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println("*                                     *");
//        System.out.printf("      SURFING '%s'          \n", key);
//        System.out.println("*                                     *");
//        System.out.println("*   Press 'Enter key' to end surf     *");
//        System.out.println("*                                     *");
//        System.out.println("* * * * * * * * * * * * * * * * * * * *");
//        System.out.println();
//
//        Thread thread = new Thread(() -> {
//            do {
//                long now = System.currentTimeMillis();
//                float secFromNow = (now - start) / 1000F;
//                if (secAvailable <= secFromNow) {
//                    //Interrupt.cancel();
//                    System.out.println("Out of money! Ended call!");
//                    break;
//                }
//            } while (true);
//        });
//
//        thread.start();
//
//        while ((System.currentTimeMillis() - start)/1000F < secAvailable) {
//            if (System.in.available() > 0) {
//                try {
//                    System.in.read();
//                }
//                catch (Exception e) {
//
//                }
//                break;
//            }
//        }
//
//        end = System.currentTimeMillis();
//        sec = Math.round((end - start) / 1000F);
//        System.out.println("Surfed: " + sec + " seconds");
//        vn.moblie.views.phone.MainAccount.mainAccount -= sec * PRICE_SURF_APPS_PER_SEC;
//        vn.moblie.views.menu.MainMenu.selectMainMenu();
//    }
//}