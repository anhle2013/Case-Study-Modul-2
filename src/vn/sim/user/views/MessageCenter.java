package vn.sim.user.views;

import vn.sim.modals.Message;
import vn.sim.user.service.IMessageCenterService;
import vn.sim.user.service.MessageCenterService;
import vn.sim.utils.AppUtils;
import vn.sim.utils.InstantUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class MessageCenter {
    String choice;
    Scanner scanner = new Scanner(System.in);
    String newMessage;
    final int PRICE_PER_PIECE_MESSAGE = 200;
    final int PIECE = 10;
    IMessageCenterService messageCenterService = new MessageCenterService();

    public void getMessageCenter(String phoneNumber) {
        if (AppUtils.simIsActive(phoneNumber)) {
            do {
                System.out.println();
                System.out.println("* * * * * --- MESSAGE CENTER --- * * * * *");
                System.out.println("*                                        *");
                System.out.println("*     1. Creat new message               *");
                System.out.println("*     2. Dafts                           *");
                System.out.println("*     3. Inbox                           *");
                System.out.println("*     4. Sendbox                         *");
                System.out.println("*                                        *");
                System.out.println("*     8. Return                          *");
                System.out.println("*     0. Exit                            *");
                System.out.println("*                                        *");
                System.out.println("* * * * * * * * * * ** * * * * * * * * * *");
                System.out.println("\nSelect action: ");
                System.out.print("⭆ ");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        newMessage = creatNewMessage();
                        selectAction(phoneNumber,newMessage);
                        break;
                    case "2":
                        System.out.println("|_______________________________________________________|");
                        System.out.println("|                      DRAFTS                           |");
                        System.out.println("|-------------------------------------------------------|");
                        displayMessages(messageCenterService.getDrafts(phoneNumber));
                        break;
                    case "3":
                        System.out.println("|_______________________________________________________|");
                        System.out.println("|                      INBOX                            |");
                        System.out.println("|-------------------------------------------------------|");
                        displayMessages(messageCenterService.getInbox(phoneNumber));
                        break;
                    case "4":
                        System.out.println("|_______________________________________________________|");
                        System.out.println("|                      SENDBOX                          |");
                        System.out.println("|-------------------------------------------------------|");
                        displayMessages(messageCenterService.getSendbox(phoneNumber));
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

    public String creatNewMessage() {
        System.out.print("Enter message: ");
        newMessage = scanner.nextLine();
        return newMessage;
    }

    private void selectAction(String phoneNumber, String message) {
        System.out.println("Select your action with this message:");
        System.out.println("1. Save draft");
        System.out.println("2. Send message");
        System.out.println("3. Cancel and delete this");
        System.out.print("⭆ ");
        choice = scanner.nextLine();
        switch (choice) {
            case "1":
                messageCenterService.saveDraft(phoneNumber, message);
                break;
            case "2":
                String toPhoneNumber = AppUtils.checkPhoneToDo(phoneNumber);
                int pieces = (int) Math.ceil((double)message.length() / PIECE);
                int money = PRICE_PER_PIECE_MESSAGE * pieces;
                int mainAccount = AppUtils.getMainAccount(phoneNumber);
                if (toPhoneNumber == null)
                    messageCenterService.saveDraft(phoneNumber, message);
                else if (money > mainAccount) {
                    System.out.println("Not enough main account! Message auto save, check Drafts");
                    messageCenterService.saveDraft(phoneNumber, message);
                }
                else {
                    messageCenterService.sendMessage(phoneNumber, toPhoneNumber, message);
                    AppUtils.setMainAccount(phoneNumber, mainAccount - money);
                }
                break;
            case "3":
                return;
            default:
                System.out.println("Action not found! Please try again");
        }
    }
    private void displayMessage(Message message) {
        System.out.println("_________________________________________________________");
        System.out.println("                          " +
                InstantUtils.instantToString(message.getTime()));
        System.out.println("\t" + message.getText());
        System.out.println("_________________________________________________________");
    }
    public void displayMessages(ArrayList<Message> messages) {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println("(" + i + 1 + ")");
            System.out.printf("From: %s                     To: %s\n",
                    messages.get(i).getFromPhone(),messages.get(i).getToPhone());
            displayMessage(messages.get(i));
            System.out.println();
        }
    }
}
