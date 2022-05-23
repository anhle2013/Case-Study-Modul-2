package vn.sim.user.views;

import vn.sim.user.service.InternetCenterService;
import vn.sim.utils.AppUtils;

import java.io.IOException;
import java.util.Scanner;

public class InternetCenter {
    Scanner scanner = new Scanner(System.in);
    String choice;
    InternetCenterService internetCenterService = new InternetCenterService();
    final int PRICE_WATCH_PER_TIME = 5000;
    final int PRICE_SEARCH_PER_TIME = 200;
    final int PRICE_SURF_APPS_PER_SEC = 200;

    public void getInternetCenter(String phoneNumber) throws IOException {
        if (AppUtils.simIsActive(phoneNumber)) {
            do {
                System.out.println();
                System.out.println("* * * * -- INTERNET CENTER -- * * * *");
                System.out.println("*                                   *");
                System.out.println("*     1. Search                     *");
                System.out.println("*     2. Watch video                *");
                System.out.println("*     3. Surf apps                  *");
                System.out.println("*                                   *");
                System.out.println("*     8. Return                     *");
                System.out.println("*     0. Exit                       *");
                System.out.println("*                                   *");
                System.out.println("* * * * * * * * * * * * * * * * * * *");
                System.out.println("\nSelect action: ");
                System.out.print("⭆ ");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        search(phoneNumber);
                        break;
                    case "2":
                        watchVideo(phoneNumber);
                        break;
                    case "3":
                        surfApps(phoneNumber);
                    case "8":
                        return;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Action not found! Please try again");
                }
            } while (true);
        } else
            System.out.println("SIM WAS LOCKED OR DISABLED");
    }

    public void search(String phoneNumber) {
        String key;
        int mainAccount = AppUtils.getMainAccount(phoneNumber);
        if (mainAccount < PRICE_SEARCH_PER_TIME) {
            System.out.println("Not enough money to search, please deposit more!");
            return;
        }
        System.out.print("Enter key to search: ");
        key = scanner.nextLine();
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                     *");
        System.out.println("*             SEARCHING               *");
        System.out.println("*                                     *");
        System.out.println("   " + key + " is: ........");
        System.out.println("*                                     *");
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        AppUtils.setMainAccount(phoneNumber, mainAccount - PRICE_SEARCH_PER_TIME);
    }

    public void watchVideo(String phoneNumber) {
        String key;
        int mainAccount = AppUtils.getMainAccount(phoneNumber);
        if (mainAccount < PRICE_WATCH_PER_TIME) {
            System.out.println("Not enough money to watch video, please deposit more!");
            return;
        }
        System.out.print("Enter key to search: ");
        key = scanner.nextLine();
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println("*          WATCHING VIDEO             *");
        System.out.println("*                                     *");
        System.out.println("   " + key);
        System.out.println("*                                     *");
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        AppUtils.setMainAccount(phoneNumber, mainAccount - PRICE_WATCH_PER_TIME);
    }

    public void surfApps(String phoneNumber) throws IOException {
        String key;
        long start, end;
        int sec;
        int mainAccount = AppUtils.getMainAccount(phoneNumber);
        int secAvailable = mainAccount / PRICE_SURF_APPS_PER_SEC;
        if (secAvailable <= 0) {
            System.out.println("Not enough money to surf app, please deposit more!");
            return;
        }

        System.out.print("Enter app to surf: ");
        key = scanner.nextLine();
        start = System.currentTimeMillis();
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.printf("      SURFING '%s'          \n", key);
        System.out.println("*                                     *");
        System.out.println("*   Press 'Enter key' to end surf     *");
        System.out.println("*                                     *");
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println();

        Thread thread = new Thread(() -> {
            do {
                long now = System.currentTimeMillis();
                float secFromNow = (now - start) / 1000F;
                if (secAvailable <= secFromNow) {
                    System.out.println("Out of money! Ended call!");
                    break;
                }
            } while (true);
        });
        thread.start();
        while ((System.currentTimeMillis() - start)/1000F < secAvailable) {
            if (System.in.available() > 0) {
                try {
                    System.in.read();
                }
                catch (Exception ignored) {

                }
                break;
            }
        }
        end = System.currentTimeMillis();
        sec = Math.round((end - start) / 1000F);
        System.out.println("Surfed: " + sec + " seconds");
        int money = sec * PRICE_SURF_APPS_PER_SEC;
        AppUtils.setMainAccount(phoneNumber,mainAccount - money);
    }
}

