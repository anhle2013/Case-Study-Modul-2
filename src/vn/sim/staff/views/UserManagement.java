package vn.sim.staff.views;

import vn.sim.modals.SimUser;
import vn.sim.staff.services.IStaffService;
import vn.sim.staff.services.StaffService;

import java.util.List;
import java.util.Scanner;

public class UserManagement {
    IStaffService staffService = new StaffService();
    StaffView staffView = new StaffView();
    Scanner scanner = new Scanner(System.in);
    String choice;
    String key;
    String personId;
    boolean existSerial;
    boolean existPhoneNumber;
    boolean existPersonId = false;
    boolean existEmail;
    boolean reSelect;
    public void getUserManagementMenu() {
        do {
            System.out.println("USER MANAGEMENT");
            System.out.println();
            System.out.println("1. Add new user");
            System.out.println("2. Find user");
            System.out.println("3. Get user info");
            System.out.println("4. Display all users");
            System.out.println();
            System.out.println("8. Back");
            System.out.println("0. Exit");
            System.out.print("Choose your action: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    SimUser newUser = addUser();
                    staffService.addUser(newUser);
                    break;
                case "2":
                    key = inputKeyword();
                    displayUsers(staffService.findUsers(key));
                    break;
                case "3":
                    String personId = inputPersonId();
                    existPersonId = staffService.existPersonId(personId);
                    if (existPersonId)
                        getUserInfo(staffService.getUser(personId));
                    else reInputPersonId();
                    break;
                case "4":
                    displayUsers(staffService.findAll());
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

        System.out.println("Add new user:");
        do {
            System.out.print("\tEnter Sim serial: ");
            serial = scanner.nextLine();
            existSerial = staffService.existSerial(serial);
            if (existSerial)
                System.out.println("This Sim serial NOT available or using! Please try another!");
        } while (existSerial);

        do {
            System.out.print("\tEnter phone number: ");
            phoneNumber = scanner.nextLine();
            existPhoneNumber = staffService.existPhoneNumber(phoneNumber);
            if (existPhoneNumber)
                System.out.println("This Phone number NOT available or using! Please try another!");
        } while (existPhoneNumber);

        System.out.print("\tEnter password: ");
        password = scanner.nextLine();

        do {
            System.out.print("\tEnter Person id: ");
            personId = scanner.nextLine();
            existPersonId = staffService.existPersonId(personId);
            if (existPersonId)
                System.out.println("This ID already available! Try another id!");
        } while (existPersonId);

        System.out.print("\tEnter name: ");
        name = scanner.nextLine();

        do {
            System.out.print("\tEnter email:");
            email = scanner.nextLine();
            existEmail = staffService.existEmail(email);
            if (existEmail)
                System.out.println("This email already available! Try another id!");
        } while (existEmail);

        return new SimUser(serial,phoneNumber,password,personId,name,email);
    }

    public String inputKeyword() {
        System.out.print("Input keyword: ");
        key = scanner.nextLine();
        System.out.printf("\n      SEARCH BY KEY: '%s' \n", key);
        return key;
    }

    public String inputPersonId() {
        System.out.print("Input person id: ");
        personId = scanner.nextLine();
        System.out.printf("\n      SEARCH BY ID: '%s' \n", personId);
        return personId;
    }
    public void reInputPersonId() {
        System.out.print("Person id NOT available!");
        do {
            System.out.println("Do you want to re-input Person Id?");
            System.out.println("-----------------------------------------");
            System.out.println("Press 'y' to re-input, or 'n' to cancel");
            key = scanner.nextLine();
            switch (key) {
                case "y":
                    inputPersonId();
                    break;
                case "n":
                    return;
                default:
                    System.out.println("Invalid action! Please select again!");
            }
        } while (true);
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
        do {
            System.out.println("Do you want to update any user's infomation?");
            System.out.println("-----------------------------------------");
            System.out.println("Press 'y' to Update, or 'n' to cancel");
            key = scanner.nextLine();
            switch (key) {
                case "y":
                    UpdateUserInfo updateUserInfo = new UpdateUserInfo();
                    updateUserInfo.getUserMenu(user);
                    break;
                case "n":
                    return;
                default:
                    System.out.println("Invalid action! Please select again!");
            }
        }while (true);
    }
}

