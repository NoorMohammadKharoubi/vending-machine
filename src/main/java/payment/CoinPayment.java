package payment;

import enums.ECoin;
import utils.Keypad;

public class CoinPayment implements Payment{
    @Override
    public double insert() {
        System.out.println("Please insert coin");
        double insertedCoin = Double.parseDouble(Keypad.readFromUser());
        if (ECoin.contains(insertedCoin)){
            return insertedCoin;
        }else{
            System.out.println("Coin not valid");
        }
        return 0;
    }
    @Override
    public double insert(double value) {
        return insert();
    }
}
