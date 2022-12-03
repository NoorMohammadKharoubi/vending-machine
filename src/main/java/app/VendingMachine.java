package app;

import enums.EPaymentTypes;
import lombok.Getter;
import lombok.Setter;

import services.ItemSlotService;
import services.PaymentService;
import utils.Keypad;

import java.util.List;


@Getter
@Setter
abstract class VendingMachine {
    private ItemSlotService itemSlotService;
    private PaymentService paymentService;
    private String[] codes;

    private int ROWS;
    private int COLS;

    public VendingMachine(){
        initMachine();
    }
    //Initializer for VM
    public abstract void initMachine();

    public abstract EPaymentTypes[] getPaymentTypes();

    //This method will check if the selected item is available and display its price
    public void pickItem(String code){
        itemSlotService.selectItem(code);
        System.out.println("Price: "+ itemSlotService.getPriceForSelectedItem());
    }

    public void cancelItem(){
        itemSlotService.cancelItem();
    }

    //returns price for specific item
    public double getPriceForSelectedItem(){
        return itemSlotService.getPriceForSelectedItem();
    }

    // This method will reduce number of specific item by 1
    public void buyItem(){
        if(canBuyItem()){
            paymentService.setCurrentAmount(getCurrentAmount() - getPriceForSelectedItem());;
            System.out.println("Item -> " + itemSlotService.BuyItem().getName());
        }
    }

    //This method to select the payment method, and insert the money accordingly
    public void insertMoney(){
        System.out.println("please select payment method");
        for (EPaymentTypes payment:getPaymentTypes()) {
            System.out.println(payment.getCode()+"- " + payment.getName());
        }
        String paymentMethod = Keypad.readFromUser();
        paymentService.pay(getRemainingAmountToPay(),paymentMethod);

    }

    // returns the current status/amount of VM
    public void printMachineStatus(){
        System.out.println("============");
        System.out.println("Amount: "+ getCurrentAmount());
        System.out.println("============");
    }

    // print the available items in VM
    public void printAvailableItems(){
        System.out.println("Available Items");
        for (int i=0; i<codes.length;i++){
            if(i % getCOLS() == 0)
                System.out.println("");
            System.out.printf("%-4s-> %-10s|", codes[i], itemSlotService.getNameOfItem(codes[i]));
        }
    }

    // To refund the remaining money
    public void refundMoney(){
        System.out.println("Amount to refund = " + getCurrentAmount());
        List<Object> objects = paymentService.refund();
        System.out.println(objects);
    }

    //To Check if the current amount is enough to buy the item
    public boolean canBuyItem(){
        return getPriceForSelectedItem() <= getCurrentAmount();
    }

    //Returns the rest amount on the customer to buy the item
    public double getRemainingAmountToPay() {
        return getPriceForSelectedItem() - getCurrentAmount();
    }

    //Gets current amount(money) which user has entered
    public double getCurrentAmount(){
        return paymentService.getCurrentAmount();
    }
}
