package com.codecool.biliardsaloon.tableType;

public abstract class BilliardTable {

    protected int pricePerHour;
    protected TableType type;
    protected boolean isAvailable = true;
    protected String name;

    public BilliardTable(TableType type, int pricePerHour, String name){
        if (!isAvailable){
            System.out.println("This table is occupied");
        } else {
            this.type = type;
            this.pricePerHour = pricePerHour;
            this.name = name;
        }
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    abstract boolean isAvailable();

    public void reserve(){
        isAvailable = false;
    }

    public void release(){
        isAvailable = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
