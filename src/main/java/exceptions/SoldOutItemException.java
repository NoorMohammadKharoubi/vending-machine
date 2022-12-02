package exceptions;

public class SoldOutItemException extends RuntimeException{
    public SoldOutItemException(String item){
        super(item + " Sold OUT!!!");
    }
}