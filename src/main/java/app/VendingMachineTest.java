package app;

import utils.Keypad;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachineFactory.getMachine("Snack");
        vendingMachine.printMachineStatus();
        while(true){
            try {
                vendingMachine.printAvailableItems();
                System.out.println("\nPlease select item ");
                vendingMachine.pickItem(Keypad.readFromUser());
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
}}
