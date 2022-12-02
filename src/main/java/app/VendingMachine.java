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
    public abstract void initMachine();

    public abstract EPaymentTypes[] getPaymentTypes();

    public void pickItem(String code){
        itemSlotService.selectItem(code);
        System.out.println("Price: "+ itemSlotService.getPriceForSelectedItem());
    }

    public void cancelItem(){
        itemSlotService.cancelItem();
    }

    public double getPriceForSelectedItem(){
        return itemSlotService.getPriceForSelectedItem();
    }

    public void buyItem(){
        if(canBuyItem()){
            paymentService.setCurrentAmount(getCurrentAmount() - getPriceForSelectedItem());;
            System.out.println("Item -> " + itemSlotService.BuyItem().getName());
        }
    }

    public void insertMoney(){
        System.out.println("please select payment method");
        for (EPaymentTypes payment:getPaymentTypes()) {
            System.out.println(payment.getCode()+"- " + payment.getName());
        }
        String paymentMethod = Keypad.readFromUser();
        paymentService.pay(getRemainingAmount(),paymentMethod);

    }

    public void printMachineStatus(){
        System.out.println("============");
        System.out.println("Amount: "+ getCurrentAmount());
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

    public void refundMoney(){
        System.out.println("Amount to refund = " + getCurrentAmount());
        List<Object> objects = paymentService.refund();
        System.out.println(objects);
    }

    public boolean canBuyItem(){
        return getPriceForSelectedItem() <= getCurrentAmount();
    }

    public double getRemainingAmount() {
        return getPriceForSelectedItem() - getCurrentAmount();
    }

    public double getCurrentAmount(){
        return paymentService.getCurrentAmount();
    }
}
