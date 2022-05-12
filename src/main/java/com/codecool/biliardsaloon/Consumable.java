package com.codecool.biliardsaloon;

public class Consumable {

    private String name;
    private ConsumableType type;
    private int price;

    public Consumable(String name, ConsumableType type, int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ConsumableType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
