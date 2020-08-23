package cn.edu.guet.exception;

public class updateException extends RuntimeException {
    public updateException(){
        super();
    }
    public updateException(String errorMessage){
        super(errorMessage);
    }
}