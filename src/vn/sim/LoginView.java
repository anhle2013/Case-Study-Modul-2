package vn.sim;

import vn.sim.modals.Staff;
import vn.sim.staff.services.StaffService;
import vn.sim.staff.views.StaffView;
import vn.sim.user.views.UserView;

import java.io.IOException;
import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    StaffService staffService = new StaffService();
    Staff staff = new Staff();

    public void login() throws IOException {
        System.out.println("* * * * * * * * * * --- LOGIN --- * * * * * * * * * *");
        System.out.println("Note: If you're sim user, User = Phone number!");
        do {
            System.out.print("Enter user: ");
            String user = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (staffService.userLogin(user, password) != null) {
                System.out.println("Welcome " + user);
                UserView userView = new UserView();
                userView.getMainMenu(user);
            }
            else if (staff.staffLogin(user, password) != null) {
                StaffView staffView = new StaffView();
                staffView.getMainMenu();
            } else {
                System.out.println("Wrong user or password! Please try again!");
            }
        } while (true);
    }
}

