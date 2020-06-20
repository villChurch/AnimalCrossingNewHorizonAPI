package com.williamspires.acnhapi.Exceptions;

public class InsectNotFoundException extends RuntimeException{
    public InsectNotFoundException(String insect){
        super("Could not find insect called " + insect);
    }
}
