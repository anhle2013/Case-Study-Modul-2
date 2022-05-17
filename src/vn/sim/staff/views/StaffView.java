package vn.sim.staff.views;

import java.util.Scanner;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    String choice;
    //boolean reSelect;
    public void getMainMenu() {
        do {
            System.out.println("MAIN MENU FOR STAFF");
            System.out.println();
            System.out.println("1. User management");
            System.out.println("2. Serial management");
            System.out.println("3. Card management");
            System.out.println();
            System.out.println("0. Exit");
            System.out.print("Choose your action: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    //reSelect = false;
                    UserManagement userManagement = new UserManagement();
                    userManagement.getUserManagementMenu();
                    break;
                case "2":
                    //reSelect = false;
                    SerialManagement serialManagement = new SerialManagement();
                    serialManagement.getSerialManagementMenu();
                    break;
                case "3":
                    //reSelect = false;
                    CardManagement cardManagement = new CardManagement();
                    cardManagement.getCardManagentMenu();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action! Please select again!");
                    //reSelect = true;
            }
        } while (true);
    }
}
