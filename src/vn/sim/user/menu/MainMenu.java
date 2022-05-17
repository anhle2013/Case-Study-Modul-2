//package vn.moblie.views.menu;
//
//import java.io.IOException;
//import java.util.Scanner;
//
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
