package com.williamspires.acnhapi.Exceptions;

public class ReactionNotFoundException extends RuntimeException{
    public ReactionNotFoundException(String reaction){
        super("No reaction found called " + reaction);
    }
}
