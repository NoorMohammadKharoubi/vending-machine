package app;

import enums.EPaymentTypes;
import lombok.Getter;
import lombok.Setter;

import payment.Payment;
import payment.PaymentFactory;
import services.ItemSlotService;
import services.PaymentService;
import utils.Keypad;


@Getter
@Setter
abstract class VendingMachine {
    private ItemSlotService itemSlotService;
    private PaymentService paymentService;
    private String[] codes;

    private int ROWS;
    private int COLS;

    private double currentAmount=0;

    public VendingMachine(){
        initMachine();
    }
    public abstract void initMachine();

    public abstract EPaymentTypes[] getPaymentTypes();

    public void pickItem(String code){
        itemSlotService.pickItem(code);
        System.out.println("Price: "+ itemSlotService.getPriceForSelectedItem());
    }

    public void dropItem(){
        itemSlotService.dropItem();
    }

    public double getPriceForSelectedItem(){
        return itemSlotService.getPriceForSelectedItem();
    }

    public void buyItem(){

    }

    public void insertMoney(){
        System.out.println("please select payment method");
        for (EPaymentTypes payment:getPaymentTypes()) {
            System.out.println(payment.getCode()+"- " + payment.getName());
        }
        Payment paymentMethod = PaymentFactory.getPaymentStrategy(Keypad.readFromUser());
        currentAmount+=paymentMethod.insert();

    }

    public void printMachineStatus(){
        System.out.println("============");
        System.out.println("Amount: "+ paymentService.getCurrentAmount());
        System.out.println("============");
    }

    public void printAvailableItems(){
        System.out.println("Available Items");
        for (int i=0; i<codes.length;i++){
            if(i % getCOLS() == 0)
                System.out.println("");
            System.out.printf("%-4s-> %-10s|", codes[i], itemSlotService.getNameOfItem(codes[i]));
        }
    }
}
