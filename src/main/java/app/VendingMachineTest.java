package app;

import utils.Keypad;

/**
 * This Class is used to test VM
 */
public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachineFactory.getMachine("Snack");
        vendingMachine.printMachineStatus();
        while(true){
            try {
                vendingMachine.printAvailableItems();
                System.out.println("\nPlease select item ");
                vendingMachine.pickItem(Keypad.readFromUser());
                while (true){
                    vendingMachine.insertMoney();
                    System.out.println("Amount = " + vendingMachine.getCurrentAmount());
                    if (!vendingMachine.canBuyItem()){
                        System.out.println("Do you want to add another money?(yes/no)");
                        String chioce = Keypad.readFromUser().toLowerCase();
                        if (chioce.equals("yes")){
                            continue;
                        }
                    }
                    break;
                }
                vendingMachine.buyItem();
                vendingMachine.refundMoney();
                System.out.println();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
}}
