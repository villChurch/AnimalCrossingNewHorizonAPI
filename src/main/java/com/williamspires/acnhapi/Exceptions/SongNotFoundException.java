package com.williamspires.acnhapi.Exceptions;

public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(String song){
        super("Could not find any villagers with a favourite song of " + song);
    }
}
