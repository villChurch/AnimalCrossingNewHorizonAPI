package com.williamspires.acnhapi.Exceptions;

public class ArtworkNotFoundException extends RuntimeException{
    public ArtworkNotFoundException(String artwork){
        super("Could not find artwork called " + artwork);
    }
}
