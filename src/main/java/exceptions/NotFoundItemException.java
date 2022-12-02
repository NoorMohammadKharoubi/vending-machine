package exceptions;

public class NotFoundItemException extends RuntimeException{
    public NotFoundItemException(String code){
        super(code + " doesn't exist");
    }
}
