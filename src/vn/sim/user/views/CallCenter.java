package vn.sim.user.views;

import vn.sim.user.service.CallCenterService;
import vn.sim.user.service.ICallCenterService;
import vn.sim.utils.AppUtils;

import java.io.IOException;
import java.util.Scanner;

public class CallCenter {
    ICallCenterService callCenterService = new CallCenterService();
    Scanner scanner = new Scanner(System.in);
    String choice;

    public void getCallCenter(String phoneNumber) throws IOException {
        if (AppUtils.simIsActive(phoneNumber)) {
            do {
                System.out.println();
                System.out.println("* * * * * -- CALL CENTER -- * * * * *");
                System.out.println("*                                   *");
                System.out.println("*     1. Deposit main account       *");
                System.out.println("*     2. Check SIM                  *");
                System.out.println("*     3. Dial a call                *");
                System.out.println("*                                   *");
                System.out.println("*     8. Return                     *");
                System.out.println("*     0. Exit                       *");
                System.out.println("*                                   *");
                System.out.println("* * * * * * * * * * * * * * * * * * *");
                System.out.println("\nSelect action: ");
                System.out.print("⭆ ");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        deposit(phoneNumber);
                        break;
                    case "2":
                        getSIMMenu(phoneNumber);
                        break;
                    case "3":
                        call(phoneNumber);
                        break;
                    case "8":
                        return;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Action not found! Please try again");
                }
            } while (true);
        } else
            System.out.println("SIM WAS LOCKED OR DISABLED");
    }

    public void deposit(String phoneNumber) {
        if (AppUtils.simIsActive(phoneNumber)) {
            System.out.print("Enter code: ");
            String code = scanner.nextLine();
            boolean check = callCenterService.checkCard(code,phoneNumber);

            if (check) {
                int value = callCenterService.deposit(phoneNumber,code);
                System.out.println("Congratulation! You just added " + value + " to Main account");
            } else {
                System.out.println("Code does not exist or used!");
                int count = callCenterService.inputWrongCode(phoneNumber);
                System.out.printf("\nWARNING: User %s input wrong card code %d times!",phoneNumber,count);
                if (count == 3)
                    System.out.printf("\nUser %s was LOCKED! Contact STAFF to unlock and continue use SIM", phoneNumber);
            }
        } else
            System.out.println("SIM WAS LOCKED OR DISABLED");
    }

    public void getSIMMenu(String phoneNumber) {
        if (AppUtils.simIsActive(phoneNumber)) {
            System.out.println();
            System.out.println("* * * * * * --- SIM MENU --- * * * * * *");
            System.out.println("*                                      *");
            System.out.println("*     1. Check main account            *");
            System.out.println("*     2. Check promotion account       *");
            System.out.println("*     3. Check available package       *");
            System.out.println("*                                      *");
            System.out.println("*     8. Return                        *");
            System.out.println("*     0. Exit                          *");
            System.out.println("*                                      *");
            System.out.println("* * * * * * * * ** * * * * * * * * * * *");
            System.out.println("\nSelect action: ");
            System.out.print("⭆ ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    int mainAccount = AppUtils.getMainAccount(phoneNumber);
                    System.out.println("Main account: " + mainAccount);
                    break;
                case "2":
                    //PromotionAccount.run();
                    break;
                case "3":
                    //AvailablePackage.run();
                    break;
                case "8":
                    return;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Action not found! Please try again");
            }
        } else
            System.out.println("SIM WAS LOCKED OR DISABLED");
    }

    public void call(String phoneNumber) throws IOException {
        if (AppUtils.simIsActive(phoneNumber)) {
            String toPhoneNumber;
            final int PRICE_CALL_PER_SEC = 500;
            int sec;
            long start, end;
            int mainAccount = AppUtils.getMainAccount(phoneNumber);
            int secAvailable = mainAccount / PRICE_CALL_PER_SEC;
            if (secAvailable <= 0) {
                System.out.println("Not enough money to dial call, please deposit more!");
                return;
            }
            toPhoneNumber = AppUtils.checkPhoneToDo(phoneNumber);
            if (toPhoneNumber == null)
                return;
            start = System.currentTimeMillis();
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                     *");
            System.out.printf("*      CALLING to %s          * \n", toPhoneNumber);
            System.out.println("*                                     *");
            System.out.println("*   Press 'Enter key' to end call     *");
            System.out.println("*                                     *");
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
            System.out.println();
            Thread thread = new Thread(() -> {
                do {
                    long now = System.currentTimeMillis();
                    float secFromNow = (now - start) / 1000F;
                    if (secAvailable <= secFromNow) {
                        System.out.println("Out of money! Ended call!");
                        break;
                    }
                } while (true);
            });
            thread.start();
            while ((System.currentTimeMillis() - start)/1000F < secAvailable) {
                if (System.in.available() > 0) {
                    try {
                        System.in.read();
                    }
                    catch (Exception ignored) {

                    }
                    break;
                }
            }
            end = System.currentTimeMillis();
            sec = Math.round((end - start) / 1000F);
            System.out.println("Called: " + sec + " seconds");
            int money = sec * PRICE_CALL_PER_SEC;
            AppUtils.setMainAccount(phoneNumber,mainAccount - money);
        } else
            System.out.println("SIM WAS LOCKED OR DISABLED");
    }
}

