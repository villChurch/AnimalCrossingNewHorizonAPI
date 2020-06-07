package com.williamspires.acnhapi.Exceptions;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String recipe){
        super("Could not find any recipes called " + recipe);
    }
}
