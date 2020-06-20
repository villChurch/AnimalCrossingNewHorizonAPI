package com.williamspires.acnhapi.Exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String event){
        super("Could not find event with name " + event);
    }
}
