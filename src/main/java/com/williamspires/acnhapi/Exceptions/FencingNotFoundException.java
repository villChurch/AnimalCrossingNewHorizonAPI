package com.williamspires.acnhapi.Exceptions;

public class FencingNotFoundException extends RuntimeException{
    public FencingNotFoundException(String fencing){
        super("Could not find fencing with name " + fencing);
    }
}
