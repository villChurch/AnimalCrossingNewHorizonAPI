package com.williamspires.acnhapi.Exceptions;

public class FossilNotFoundException extends RuntimeException{
    public FossilNotFoundException(String fossil){
        super("Could not found fossil called " + fossil);
    }
}
