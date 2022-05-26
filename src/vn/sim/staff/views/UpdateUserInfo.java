package vn.sim.staff.views;

import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;
import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.IUpdateUserService;
import vn.sim.staff.services.StaffService;
import vn.sim.staff.services.UpdateUserService;
import vn.sim.utils.AppUtils;
import vn.sim.utils.ValidateUtils;

import java.util.Scanner;

public class UpdateUserInfo {
    IUpdateUserService updateUserService = new UpdateUserService();
    IStaffService staffService = new StaffService();
    String choice;
    Scanner scanner = new Scanner(System.in);

    boolean input;
    boolean existsSerial, existsPersonId, existsEmail;
    String newValue;
    public void getUserMenu(SimUser user) {
        do {
            SimUser newUser = new SimUser();
            newUser.setPhoneNumber(user.getPhoneNumber());
            System.out.println();
            System.out.println("* * * * * --- UPDATE USER INFORMATION --- * * * * *");
            System.out.println("*                                                 *");
            System.out.println("*     1. Change serial                            *");
            System.out.println("*     2. Update person id                         *");
            System.out.println("*     3. Update name                              *");
            System.out.println("*     4. Update email                             *");
            System.out.println("*     5. Change Sim Status                        *");
            System.out.println("*                                                 *");
            System.out.println("*     8. Return                                   *");
            System.out.println("*     0. Exit                                     *");
            System.out.println("*                                                 *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("\nSelect action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    do {
                        System.out.println("Enter new serial: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isSerialValid(newValue);
                        if (!input)
                            System.out.println("Serial NOT validate!");
                        existsSerial = staffService.existSerial(newValue);
                        if (existsSerial)
                            System.out.println("This serial is using by another!");
                    } while (!input || existsSerial);
                    updateUserService.changeSerial(newUser,newValue);
                    staffService.updateCSV(newUser);
                    break;
                case "2":
                    do {
                        System.out.println("Enter new Person id: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isPersonIdValid(newValue);
                        if (!input)
                            System.out.println("Person id NOT validate!");
                        existsPersonId = staffService.existPersonId(newValue);
                        if (existsPersonId)
                            System.out.println("This Person id is using by another!");
                    } while (!input || existsPersonId);
                    updateUserService.updatePersonId(newUser,newValue);
                    staffService.updateCSV(newUser);
                    break;
                case "3":
                    do {
                        System.out.println("Enter new name: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isNameValid(newValue);
                        if (!input)
                            System.out.println("Person name NOT validate!");
                    } while (!input);
                    updateUserService.updateName(newUser,newValue);
                    staffService.updateCSV(newUser);
                    break;
                case "4":
                    do {
                        System.out.println("Enter new email: ");
                        newValue = AppUtils.inputString();
                        input = ValidateUtils.isEmailValid(newValue);
                        if (!input)
                            System.out.println("Email NOT validate!");
                        existsEmail = staffService.existEmail(newValue);
                        if (existsEmail)
                            System.out.println("This Email is using by another!");
                    } while (!input || existsEmail);
                    updateUserService.updateEmail(newUser,newValue);
                    staffService.updateCSV(newUser);
                    break;
                case "5":
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
            SimUser newUser = new SimUser();
            newUser.setPhoneNumber(user.getPhoneNumber());
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
            System.out.println("\nSelect action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    newStatus = SimStatus.ACTIVE;
                    updateUserService.changeSimStatus(newUser, newStatus);
                    System.out.println("User " + newUser.getPhoneNumber() + " is ACTIVE now");
                    staffService.updateCSV(newUser);
                    return;
                case "2":
                    newStatus = SimStatus.DISABLED;
                    updateUserService.changeSimStatus(newUser, newStatus);
                    System.out.println("User " + newUser.getPhoneNumber() + " is DISABLE now");
                    staffService.updateCSV(newUser);
                    return;
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
}
