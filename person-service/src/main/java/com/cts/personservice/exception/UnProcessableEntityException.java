package com.cts.personservice.exception;

public class UnProcessableEntityException extends RuntimeException {
    public UnProcessableEntityException(String msg){
        super(msg);
    }
    public UnProcessableEntityException(String msg, Exception e){
        super(msg,e);
    }
}
