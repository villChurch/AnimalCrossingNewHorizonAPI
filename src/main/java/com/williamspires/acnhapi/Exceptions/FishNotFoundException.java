package com.williamspires.acnhapi.Exceptions;

public class FishNotFoundException extends RuntimeException{
    public FishNotFoundException(String fish){
        super("Could not find fish called " + fish);
    }
}
