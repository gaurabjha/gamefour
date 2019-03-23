package com.skylark.model;

public class Player {
    private final char sprite;
    private final String name;
    private int choice;
    private final boolean isBot;

    public Player(String name, char sprite,  boolean isBot) {
        this.sprite = sprite;
        this.name = name;
        this.isBot = isBot;
    }

    public void play(){
        isBot
    }

}
