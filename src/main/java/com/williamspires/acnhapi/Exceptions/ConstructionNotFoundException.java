package com.williamspires.acnhapi.Exceptions;

public class ConstructionNotFoundException extends RuntimeException{
    public ConstructionNotFoundException(String construction){
        super("Could not find construction item called " + construction);
    }
}
