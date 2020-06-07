package com.williamspires.acnhapi.Exceptions;

public class ShrubNotFoundException extends RuntimeException{
    public ShrubNotFoundException(String shrub){
        super("Could not find shrub called " + shrub);
    }
}
