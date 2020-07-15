package com.williamspires.acnhapi.Exceptions;

public class SeaCreatureNotFoundException extends  RuntimeException {
    public SeaCreatureNotFoundException(String seaCreature) {
        super("Could not find sea creature called " + seaCreature);
    }
}
