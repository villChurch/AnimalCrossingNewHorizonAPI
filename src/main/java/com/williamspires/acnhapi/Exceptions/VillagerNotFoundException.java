package com.williamspires.acnhapi.Exceptions;

import lombok.extern.slf4j.Slf4j;

public class VillagerNotFoundException extends RuntimeException{

    public VillagerNotFoundException(String villager) {
        super("Could not find villager with name " + villager);
    }
}
