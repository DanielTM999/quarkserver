package dtm.servers.http.exceptions;


public class ToManyRequestException extends Exception{

    public ToManyRequestException(String message){
        super(message);
    }
    
}
