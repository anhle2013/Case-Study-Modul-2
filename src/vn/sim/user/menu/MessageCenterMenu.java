//package vn.moblie.views.menu;
//
//import vn.moblie.views.messages.Draft;
//import vn.moblie.views.messages.Inbox;
//import vn.moblie.views.messages.Sendbox;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class MessageCenterMenu {
//    public static void getMessageCenter() {
//        System.out.println();
//        System.out.println("* * * * -- MESSAGE CENTER -- * * * *");
//        System.out.println("*                                  *");
//        System.out.println("*     1. Daft                      *");
//        System.out.println("*     2. Inbox                     *");
//        System.out.println("*     3. Sendbox                   *");
//        System.out.println("*     0. Return                    *");
//        System.out.println("*                                  *");
//        System.out.println("* * * * * * * * ** * * * * * * * * *");
//    }
//    public static void selectMessageCenter() throws IOException {
//        getMessageCenter();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\nSeclection action: ");
//        System.out.print("⭆ ");
//        int number = Integer.parseInt(scanner.nextLine());
//        switch (number) {
//            case 1:
//                Draft.run();
//                break;
//            case 2:
//                Inbox.run();
//                break;
//            case 3:
//                Sendbox.run();
//                break;
//            case 0:
//                vn.moblie.views.menu.MainMenu.selectMainMenu();
//                break;
//            default:
//                System.out.println("Action not found! Please try again");
//                selectMessageCenter();
//                break;
//        }
//    }
//}
