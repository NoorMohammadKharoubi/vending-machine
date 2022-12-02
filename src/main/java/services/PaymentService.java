package services;

import enums.ECoin;
import enums.ENote;
import exceptions.NotSufficientChangeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import payment.Payment;
import payment.PaymentFactory;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentService {
    private double currentAmount;
    public void pay(double value, String paymentMethod){
        Payment payment = PaymentFactory.getPaymentStrategy(paymentMethod);
        currentAmount+=payment.insert(value);
    }
    public List<Object> refund(){
        List<Object> money = new ArrayList<>();
        for (ENote note : ENote.values()) {
            currentAmount = Math.round(currentAmount * 100) / 100.0;
            while (currentAmount >= note.getValue()) {
                currentAmount -= note.getValue();
                money.add(note);
            }
        }
        for (ECoin coin : ECoin.values()) {
            currentAmount = Math.round(currentAmount * 100) / 100.0;
            while (currentAmount >= coin.getValue()) {
                currentAmount -= coin.getValue();
                money.add(coin);
            }
        }
        if(currentAmount!=0){
            throw new NotSufficientChangeException();
        }
        return money;
    }
}
