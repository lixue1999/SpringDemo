package cn.edu.guet.exception;

public class deleteException extends RuntimeException {
    public deleteException(){
        super();
    }
    public deleteException(String errorMessage){
        super(errorMessage);
    }
}