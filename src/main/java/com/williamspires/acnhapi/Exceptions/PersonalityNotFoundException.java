package com.williamspires.acnhapi.Exceptions;

public class PersonalityNotFoundException extends RuntimeException{
    public PersonalityNotFoundException(String personality){
        super("Not villagers found with a personality of " + personality);
    }
}
