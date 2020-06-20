package com.williamspires.acnhapi.Exceptions;

public class RedItemNotFoundException extends RuntimeException{
    public RedItemNotFoundException(String redItem){
        super("Could not find any Red Items called " + redItem);
    }
}
