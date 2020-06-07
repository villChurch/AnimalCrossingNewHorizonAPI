package com.williamspires.acnhapi.Exceptions;

public class ToolsNotFoundException extends RuntimeException{
    public ToolsNotFoundException(String tool){
        super("Could not find any tools called " + tool);
    }
}
