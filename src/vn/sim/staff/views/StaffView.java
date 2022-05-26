package vn.sim.staff.views;

import java.util.Scanner;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    String choice;
    public void getMainMenu() {
        do {
            System.out.println();
            System.out.println("* * * * * -- MAIN MENU FOR STAFF -- * * * * *");
            System.out.println("*                                           *");
            System.out.println("*     1. User management                    *");
            System.out.println("*     2. Serial management                  *");
            System.out.println("*     3. Card management                    *");
            System.out.println("*                                           *");
            System.out.println("*     8. Return                             *");
            System.out.println("*     0. Exit                               *");
            System.out.println("*                                           *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("\nSelect action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    UserManagement userManagement = new UserManagement();
                    userManagement.getUserManagementMenu();
                    break;
                case "2":
                    SerialManagement serialManagement = new SerialManagement();
                    serialManagement.getSerialManagementMenu();
                    break;
                case "3":
                    CardManagement cardManagement = new CardManagement();
                    cardManagement.getCardManagementMenu();
                    break;
                case "8":
                    return;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action! Please select again!");
            }
        } while (true);
    }
}
