package menu;

import java.util.Scanner;

public class MessegeCenterMenu {
    public static void getMessageCenter() {
        System.out.println();
        System.out.println("* * * * -- MESSAGE CENTER -- * * * *");
        System.out.println("*                                  *");
        System.out.println("*     1. Daft                      *");
        System.out.println("*     2. Inbox                     *");
        System.out.println("*     3. Sendbox                   *");
        System.out.println("*     0. Return                    *");
        System.out.println("*                                  *");
        System.out.println("* * * * * * * * ** * * * * * * * * *");
    }
    public static void selectMessageCenter() {
        getMessageCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeclection action: ");
        System.out.print("⭆ ");
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                message.action.Draft.run();
                break;
            case 2:
                message.action.Inbox.run();
                break;
            case 3:
                message.action.Sendbox.run();
                break;
            case 0:
                menu.MainMenu.selectMainMenu();
                break;
            default:
                System.out.println("Action not found! Please try again");
                selectMessageCenter();
                break;
        }
    }
}
