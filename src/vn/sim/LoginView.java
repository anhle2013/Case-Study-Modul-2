package vn.sim;

import vn.sim.modals.SimUser;
import vn.sim.modals.Staff;
import vn.sim.staff.services.StaffService;
import vn.sim.staff.views.StaffView;
import vn.sim.user.views.UserView;

import java.io.*;
import java.util.*;

public class LoginView {

    public void login() throws IOException {
        Scanner scanner = new Scanner(System.in);
        StaffService staffService = new StaffService();
        staffService.getAll();
        Staff staff = new Staff();
        String user, password;
        do {
            System.out.println("* * * * * * * * * * --- LOGIN --- * * * * * * * * * *");
            System.out.println("Note: If you're sim user, User = Phone number!");
            System.out.println("Enter 'out' to exit");
            System.out.println();
            System.out.print("Enter user: ");
            user = scanner.nextLine();
            if (user.equals("out"))
                System.exit(0);
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            if (password.equals("out"))
                System.exit(0);
            if (staffService.userLogin(user, password) != null) {
                System.out.println("Welcome " + user);
                UserView userView = new UserView();
                userView.getMainMenu(user);
            } else if (staff.staffLogin(user, password) != null) {
                StaffView staffView = new StaffView();
                staffView.getMainMenu();
            } else {
                System.out.println("Wrong user or password! Please try again!");
            }
        } while (true);
    }
}

