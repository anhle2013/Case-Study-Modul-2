package vn.sim.staff.views;

import vn.sim.modals.SimUser;
import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.StaffService;
import vn.sim.utils.AppUtils;
import vn.sim.utils.CSVUtils;
import vn.sim.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;


public class UserManagement {
    IStaffService staffService = new StaffService();
    private final static String PATH = "data/users.csv";
    Scanner scanner = new Scanner(System.in);
    String choice;
    String key;
    String personId;
    boolean exists;

    public void getUserManagementMenu() {
        do {
            System.out.println();
            System.out.println("* * * * * --- USER MANAGEMENT --- * * * * *");
            System.out.println("*                                         *");
            System.out.println("*     1. Add new user                     *");
            System.out.println("*     2. Find user                        *");
            System.out.println("*     3. Get user info                    *");
            System.out.println("*     4. Display all users                *");
            System.out.println("*                                         *");
            System.out.println("*     8. Return                           *");
            System.out.println("*     0. Exit                             *");
            System.out.println("*                                         *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("\nSelect action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    SimUser newUser = addUser();
                    staffService.addUser(newUser);
                    break;
                case "2":
                    System.out.println("Input keyword: ");
                    key = AppUtils.inputString();
                    System.out.printf("\n      SEARCH BY KEY: '%s' \n", key);
                    displayUsers(staffService.findUsers(key));
                    break;
                case "3":
                    System.out.println("Input person id: ");
                    personId = AppUtils.inputString();
                    exists = staffService.existPersonId(personId);
                    System.out.printf("\n      SEARCH BY ID: '%s' \n", personId);
                    if (exists)
                        getUserInfo(staffService.getUser(personId));
                    else
                        System.out.println("Person id NOT available!");
                    break;
                case "4":
                    List<SimUser> userList = staffService.getAll();
                    CSVUtils.write(PATH, userList);
                    displayUsers(userList);
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

    public SimUser addUser() {
        String serial;
        String phoneNumber;
        String password;
        String personId;
        String name;
        String email;

        boolean input;
        System.out.println("Add new user:");
        do {
            System.out.println("\tEnter Sim serial: ");
            serial = AppUtils.inputString();
            input = ValidateUtils.isSerialValid(serial);
            if (!input)
                System.out.println("Sim serial NOT validate! Please try again!");
            exists = staffService.existSerial(serial);
            if (exists)
                System.out.println("This Sim serial NOT available or using! Please try another!");
        } while (exists || !input);

        do {
            System.out.println("\tEnter Phone number: ");
            phoneNumber = AppUtils.inputString();
            input = ValidateUtils.isPhoneNumberValid(phoneNumber);
            if (!input)
                System.out.println("Phone number NOT validate! Please try again!");
            exists = staffService.existPhoneNumber(phoneNumber);
            if (exists)
                System.out.println("This Phone number NOT available or using! Please try another!");
        } while (exists || !input);

        do {
            System.out.println("\tEnter Password: ");
            password = AppUtils.inputString();
            input = ValidateUtils.isPasswordValid(password);
            if (!input)
                System.out.println("Password NOT validate! Please try again!");
        } while (!input);

        do {
            System.out.println("\tEnter Person id: ");
            personId = AppUtils.inputString();
            input = ValidateUtils.isPersonIdValid(personId);
            if (!input)
                System.out.println("Person id NOT validate! Please try again!");
            exists = staffService.existPersonId(personId);
            if (exists)
                System.out.println("This Person id NOT available or using! Please try another!");
        } while (exists || !input);

        do {
            System.out.println("\tEnter Name: ");
            name = AppUtils.inputString();
            input = ValidateUtils.isNameValid(name);
            if (!input)
                System.out.println("Name NOT validate! Please try again!");
        } while (!input);

        do {
            System.out.println("\tEnter Email: ");
            email = AppUtils.inputString();
            input = ValidateUtils.isEmailValid(email);
            if (!input)
                System.out.println("Email NOT validate! Please try again!");
            exists = staffService.existEmail(email);
            if (exists)
                System.out.println("This Email id NOT available or using! Please try another!");
        } while (exists || !input);

        return new SimUser(serial,phoneNumber,password,personId,name,email);
    }


    public void displayUsers(List<SimUser> users) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                      LIST OF USERS                                             *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("| Phone number |  Person id  |          Name           |              Email          |   Status  |");
        System.out.println("|--------------|-------------|-------------------------|-----------------------------|-----------|");
        for (SimUser user : users)
            System.out.printf("| %-13s| %-12s| %-24s| %-28s| %-10s|\n",
                    user.getPhoneNumber(),user.getPersonId(),user.getName(),user.getEmail(),user.getStatus());
        System.out.println("|______________|_____________|_________________________|_____________________________|___________|");
    }

    public void getUserInfo(SimUser user) {
        System.out.println("* * * * * * * * * * * * ** * * * * * * * * * * * * * * * * *");
        System.out.println("*                  User Information                        *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * ** * * * * * *");
        System.out.println("Serial: " + user.getSerial());
        System.out.println("Phone number: " + user.getPhoneNumber());
        System.out.println("Person id: " + user.getPersonId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Main account: " + user.getMainAccount());
        System.out.println("Promotion account: " + user.getPromotionAccount());
        System.out.println("Sim status: " + user.getStatus());
        System.out.println();

        System.out.println("Do you want to update any user's information?");
        System.out.println("-----------------------------------------");
        System.out.println("Press 'yes' to Update, or anykey to cancel");
        key = scanner.nextLine();
        if (key.equals("yes")) {
            UpdateUserInfo updateUserInfo = new UpdateUserInfo();
            updateUserInfo.getUserMenu(user);
            CSVUtils.write(PATH, staffService.getAll());
        }
    }
}

