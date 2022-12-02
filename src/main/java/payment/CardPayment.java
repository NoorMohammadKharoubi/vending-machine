package payment;

public class CardPayment implements Payment{
    @Override
    public double insert(double value) {
        return purchase(value);
    }

    @Override
    public double insert() {
        return 0;
    }

    public double purchase(double value){
        System.out.println(value + " USD has been debited");
        return value;
    }
}
