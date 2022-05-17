package vn.sim;

import vn.sim.modals.Staff;
import vn.sim.staff.services.StaffService;
import vn.sim.staff.views.StaffView;
import vn.sim.user.views.UserView;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    StaffService staffService = new StaffService();
    Staff staff = new Staff();

    boolean reLogin;

    public void login() {
        System.out.println("* * * * * * * * * * --- LOGIN --- * * * * * * * * * *");
        do {
            System.out.print("Enter user: ");
            String user = scanner.nextLine();
            System.out.print("Enter pasword: ");
            String password = scanner.nextLine();
            if (staffService.userLogin(user, password) != null) {
                reLogin = false;
                //if (staffService.getIndex())
                System.out.println("Welcome " + user);
                UserView userView = new UserView();
                userView.getMainMenu();
            }
            else if (staff.staffLogin(user, password) != null) {
                reLogin = false;
                StaffView staffView = new StaffView();
                staffView.getMainMenu();

            } else {
                System.out.println("Wrong user or password! Please try again!");
                reLogin = true;
            }
        } while (reLogin);
    }
}

//public class MainMenu {
//    public static void getMainMenu() {
//        System.out.println();
//        System.out.println("* * * * * -- MAIN MENU -- * * * * *");
//        System.out.println("*                                 *");
//        System.out.println("*     1. Call Center              *");
//        System.out.println("*     2. Message Center           *");
//        System.out.println("*     3. Browser Center           *");
//        System.out.println("*     0. Exit                     *");
//        System.out.println("*                                 *");
//        System.out.println("* * * * * * * * * * * * * * * * * *");
//    }
//    public static void selectMainMenu() throws IOException {
//        getMainMenu();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\nSeclection action: ");
//        System.out.print("⭆ ");
//        int number = Integer.parseInt(scanner.nextLine());
//        switch (number) {
//            case 1:
//                CallCenterMenu.selectCallCenter();
//                break;
//            case 2:
//                MessageCenterMenu.selectMessageCenter();
//                break;
//            case 3:
//                InternetCenterMenu.selectInternetCenter();
//                break;
//            case 0:
//                System.exit(0);
//                break;
//            default:
//                System.out.println("Action not found! Please try again");
//                selectMainMenu();
//                break;
//        }
//    }
//}
