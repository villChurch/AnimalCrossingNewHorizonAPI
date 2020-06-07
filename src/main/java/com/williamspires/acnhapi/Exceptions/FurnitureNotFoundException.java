package com.williamspires.acnhapi.Exceptions;

public class FurnitureNotFoundException extends RuntimeException{
    public FurnitureNotFoundException(String furniture){
        super("Could not find furniture called " + furniture);
    }
}
