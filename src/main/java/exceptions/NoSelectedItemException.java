package exceptions;

public class NoSelectedItemException extends RuntimeException{
    public NoSelectedItemException(){
        super("No selected item");
    }
}