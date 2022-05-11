package com.codecool.biliardsaloon.tableType;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BilliardTable {

    protected int pricePerHour;
    protected String type;
    protected boolean isAvailable = true;

    public BilliardTable(String type, int pricePerHour){
        if (!isAvailable){
            System.out.println("This table is occupied");
        } else {
            this.type = type;
            this.pricePerHour = pricePerHour;
        }
    }

    public void setAvailable() {
        isAvailable = !isAvailable;
        }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return type;
    }
}
