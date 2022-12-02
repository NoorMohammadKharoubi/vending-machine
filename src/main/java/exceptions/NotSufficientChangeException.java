package exceptions;

public class NotSufficientChangeException extends RuntimeException{
    public NotSufficientChangeException(){
        System.out.println("No Sufficient change available");
    }
}
