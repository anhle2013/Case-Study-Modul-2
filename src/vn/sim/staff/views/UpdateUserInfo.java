package vn.sim.staff.views;

import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;
import vn.sim.staff.services.IUpdateUserService;
import vn.sim.staff.services.UpdateUserService;

import java.util.Scanner;

public class UpdateUserInfo {
    IUpdateUserService updateUserService = new UpdateUserService();
    String choice;
    Scanner scanner = new Scanner(System.in);

    public void getUserMenu(SimUser user) {
        do {
            System.out.println("UPDATE USER INFOMATION");
            System.out.println();
            System.out.println("1. Change serial");
            System.out.println("2. Change phone number");
            System.out.println("3. Update person id");
            System.out.println("4. Update name");
            System.out.println("5. Update email");
            System.out.println("6. Change Sim Status");
            System.out.println();
            System.out.println("8. Back");
            System.out.println("0. Exit");
            System.out.print("Choose your action: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter new serial: ");
                    String newSerial = scanner.nextLine();
                    updateUserService.changeSerial(user,newSerial);
                    break;
                case "2":
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    updateUserService.changePhoneNumber(user,newPhoneNumber);
                    break;
                case "3":
                    System.out.print("Enter new personid: ");
                    String newPersonId = scanner.nextLine();
                    updateUserService.updatePersonId(user,newPersonId);
                    break;
                case "4":
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    updateUserService.updateName(user,newName);
                    break;
                case "5":
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    updateUserService.updateEmail(user,newEmail);
                    break;
                case "6":
                    changeSimStatusMenu(user);
                    break;
                case "0":
                    System.exit(0);
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Invalid action! Please select again!");
            }
        } while (true);
    }

    public void changeSimStatusMenu(SimUser user) {
        SimStatus newStatus;
        do {
            System.out.println("CHANGE SIM STATUS");
            System.out.println();
            System.out.println("1. Re Active SIM");
            System.out.println("2. Disable SIM");
            System.out.println();
            System.out.println("8. Back");
            System.out.println("0. Exit");
            System.out.print("Choose your action: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    newStatus = SimStatus.ACTIVE;
                    updateUserService.changeSimStatus(user, newStatus);
                    break;
                case "2":
                    newStatus = SimStatus.DISABLED;
                    updateUserService.changeSimStatus(user, newStatus);
                    break;
                case "0":
                    System.exit(0);
                    break;
                case "8":
                    break;
                default:
                    System.out.println("Invalid action! Please select again!");
            }
        } while (true);
    }
}
