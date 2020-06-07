package com.williamspires.acnhapi.Exceptions;

public class ReactionSourceNotFoundException extends RuntimeException{
    public ReactionSourceNotFoundException(String source){
        super("Could not find any reactions that come from " + source + " villagers");
    }
}
