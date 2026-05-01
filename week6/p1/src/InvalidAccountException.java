public class InvalidAccountException extends RuntimeException{
    private int errorCode;
    private String message;

    public InvalidAccountException(int errorCode, String message, Throwable cause){
        super(message, cause);
        this.errorCode = errorCode;

    }

    public InvalidAccountException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public String toString(){
        return "the account is invalid";
    }
}
