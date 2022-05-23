package vn.sim.user.views;

import java.io.IOException;
import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    String choice;
    public void getMainMenu(String phoneNumber) throws IOException {
        do {
            System.out.println();
            System.out.println("* * * * * -- MAIN MENU -- * * * * *");
            System.out.println("*                                 *");
            System.out.println("*     1. Call Center              *");
            System.out.println("*     2. Message Center           *");
            System.out.println("*     3. Browser Center           *");
            System.out.println("*                                 *");
            System.out.println("*     8. Return                   *");
            System.out.println("*     0. Exit                     *");
            System.out.println("*                                 *");
            System.out.println("* * * * * * * * * * * * * * * * * *");
            System.out.println("\nSelect action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    CallCenter callCenter = new CallCenter();
                    callCenter.getCallCenter(phoneNumber);
                    break;
                case "2":
                    MessageCenter messageCenter = new MessageCenter();
                    messageCenter.getMessageCenter(phoneNumber);
                    break;
                case "3":
                    InternetCenter internetCenter = new InternetCenter();
                    internetCenter.getInternetCenter(phoneNumber);
                    break;
                case "8":
                    return;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Action not found! Please try again");
            }
        } while (true);
    }
}

