package vn.sim.staff.views;

import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;
import vn.sim.staff.services.IUpdateUserService;
import vn.sim.staff.services.UpdateUserService;
import vn.sim.utils.AppUtils;
import vn.sim.utils.ValidateUtils;

import java.util.Scanner;

public class UpdateUserInfo {
    IUpdateUserService updateUserService = new UpdateUserService();
    String choice;
    Scanner scanner = new Scanner(System.in);

    boolean input;
    String newValue;
    public void getUserMenu(SimUser user) {
        do {
            System.out.println();
            System.out.println("* * * * * --- UPDATE USER INFOMATION --- * * * * *");
            System.out.println("*                                                *");
            System.out.println("*     1. Change serial                           *");
            System.out.println("*     2. Change phone number                     *");
            System.out.println("*     3. Update person id                        *");
            System.out.println("*     4. Update name                             *");
            System.out.println("*     5. Update email                            *");
            System.out.println("*     6. Change Sim Status                       *");
            System.out.println("*                                                *");
            System.out.println("*     8. Return                                  *");
            System.out.println("*     0. Exit                                    *");
            System.out.println("*                                                *");
            System.out.println("* * * * * * * * * * * * ** * * * * * * * * * * * *");
            System.out.println("\nSeclection action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    do {
                        System.out.println("Enter new serial: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isSerialValid(newValue);
                    } while (!input);
                    updateUserService.changeSerial(user,newValue);
                    break;
                case "2":
                    do {
                        System.out.println("Enter new phone number: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isPhoneNumberValid(newValue);
                    } while (!input);
                    updateUserService.changePhoneNumber(user,newValue);
                    break;
                case "3":
                    do {
                        System.out.println("Enter new Person id: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isPersonIdValid(newValue);
                    } while (!input);
                    updateUserService.updatePersonId(user,newValue);
                    break;
                case "4":
                    do {
                        System.out.println("Enter new name: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isNameValid(newValue);
                    } while (!input);
                    updateUserService.updateName(user,newValue);
                    break;
                case "5":
                    do {
                        System.out.println("Enter new email: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isNameValid(newValue);
                    } while (!input);
                    updateUserService.updateEmail(user,newValue);
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
            System.out.println();
            System.out.println("* * * * * --- CHANGE SIM STATUS --- * * * * *");
            System.out.println("*                                           *");
            System.out.println("*     1. Re Active SIM                      *");
            System.out.println("*     2. Disable SIM                        *");
            System.out.println("*                                           *");
            System.out.println("*     8. Return                             *");
            System.out.println("*     0. Exit                               *");
            System.out.println("*                                           *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("\nSeclection action: ");
            System.out.print("⭆ ");
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
