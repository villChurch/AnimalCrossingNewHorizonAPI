package com.williamspires.acnhapi.Exceptions;

public class OutfitNotFoundException extends RuntimeException{
    public OutfitNotFoundException(String outfit){
        super("Could not find outfit called " + outfit);
    }
}
