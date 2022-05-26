package vn.sim.utils;

import vn.sim.modals.SimStatus;
import vn.sim.modals.SimUser;
import vn.sim.staff.services.StaffService;

import java.util.List;
import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);
    static StaffService staffService = new StaffService();
    private final static String PATH = "data/users.csv";

    public static String inputString() {
        System.out.print(" ⭆ ");
        return scanner.nextLine();
    }

    public static String checkPhoneToDo(String phoneNumber) {
        String toPhoneNumber;
        boolean existsPhoneNumber;
        do {
            System.out.println("Enter phone Number to connect: ");
            toPhoneNumber = scanner.nextLine();
            existsPhoneNumber = staffService.existPhoneNumber(toPhoneNumber);
            if (toPhoneNumber.equals("out"))
                return null;
            if (!ValidateUtils.isPhoneNumberValid(toPhoneNumber))
                System.out.println("Invalid Phone number! Please try another number or Press 'out' to cancel");
            else if (!existsPhoneNumber)
                System.out.println("Phone number '" + toPhoneNumber + "' NOT available! Please try another number or Press 'out' to cancel");
            else if (toPhoneNumber.equals(phoneNumber))
                System.out.println("Can NOT do this action to yourself! Please try another number or Press 'out' to cancel");
        } while (!existsPhoneNumber || toPhoneNumber.equals(phoneNumber));
        return toPhoneNumber;
    }

    public static boolean simIsActive(String phoneNumber) {
        return staffService.getUserByPhoneNumber(phoneNumber).getStatus()== SimStatus.ACTIVE;
    }

    public static int getMainAccount(String phoneNumber) {
        return staffService.getUserByPhoneNumber(phoneNumber).getMainAccount();
    }

    public static void setMainAccount(String phoneNumber, int newMainAccount) {
        List<SimUser> userList = staffService.getAll();
        int index = -1 ;
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getPhoneNumber().equals(phoneNumber))
                index = i;
        userList.get(index).setMainAccount(newMainAccount);
        CSVUtils.write(PATH, userList);

    }


}
