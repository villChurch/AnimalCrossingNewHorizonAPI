package com.williamspires.acnhapi.Exceptions;

public class SpeciesNotFoundException extends RuntimeException{
    public SpeciesNotFoundException(String species){
        super("No villagers found with a species of " + species);
    }
}
