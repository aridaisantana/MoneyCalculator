package moneycalculator.controller;


public interface Command {
    
    String name();
    void execute();
    
}
