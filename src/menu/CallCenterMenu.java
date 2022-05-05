package menu;

import java.util.Scanner;

public class CallCenterMenu {
    private static void getCallCenter() {
        System.out.println();
        System.out.println("* * * * * -- CALL CENTER -- * * * * *");
        System.out.println("*                                   *");
        System.out.println("*     1. Deposit main account       *");
        System.out.println("*     2. Check SIM status menu      *");
        System.out.println("*     3. Performance a call         *");
        System.out.println("*     0. Return                     *");
        System.out.println("*                                   *");
        System.out.println("* * * * * * * * * * * * * * * * * * *");
    }
    public static void selectCallCenter() {
        getCallCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeclection action: ");
        System.out.print("⭆ ");
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                call.action.DepositMainAccount.run();
                break;
            case 2:
                selectSIMStatusMenu();
                break;
            case 3:
                call.action.PerformanceACall.run();
                break;
            case 0:
                menu.MainMenu.selectMainMenu();
                break;
            default:
                System.out.println("Action not found! Please try again");
                selectCallCenter();
                break;
        }
    }

    private static void checkSIMStatusMenu() {
        System.out.println();
        System.out.println("* * * * * -- SIM STATUS MENU -- * * * * *");
        System.out.println("*                                       *");
        System.out.println("*     1. Check main account             *");
        System.out.println("*     2. Check promotion account        *");
        System.out.println("*     3. Check available package        *");
        System.out.println("*     0. Return                         *");
        System.out.println("*                                       *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    }
    public static void selectSIMStatusMenu() {
        checkSIMStatusMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeclection action: ");
        System.out.print("⭆ ");
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                call.action.MainAccount.run();
                break;
            case 2:
                call.action.PromotionAccount.run();
                break;
            case 3:
                call.action.AvailablePackage.run();
                break;
            case 0:
                menu.CallCenterMenu.selectCallCenter();
                break;
            default:
                System.out.println("Action not found! Please try again");
                selectSIMStatusMenu();
                break;
        }
    }
}