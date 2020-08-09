package com.cts.personservice.exception;

public class DataConflictException extends RuntimeException{
    public DataConflictException(String msg){
    super(msg);
}
    public DataConflictException(String msg, Exception e){
        super(msg,e);
    }
}



