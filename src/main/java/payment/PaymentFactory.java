package payment;

import app.SnackMachine;
import enums.EPaymentTypes;

import java.util.Objects;


public class PaymentFactory {
    public static Payment getPaymentStrategy(String method){
        if (Objects.equals(method, EPaymentTypes.Coin.getCode())){
            return new CoinPayment();
        }else if(Objects.equals(method, EPaymentTypes.Note.getCode())){
            return new NotePayment();
        } else if (Objects.equals(method, EPaymentTypes.Card.getCode())) {
            return new CardPayment();
        }else {
            throw new IllegalArgumentException(method + " is not implemented!");
        }
    }
}
