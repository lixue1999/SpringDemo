package cn.edu.guet.exception;

public class addException extends RuntimeException {
    public addException(){
        super();
    }
    public addException(String errorMessage){
        super(errorMessage);
    }
}