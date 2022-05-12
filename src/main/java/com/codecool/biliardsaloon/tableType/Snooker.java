package com.codecool.biliardsaloon.tableType;

import java.time.LocalDateTime;

public class Snooker extends BilliardTable{

    public Snooker(TableType type) {
        super(type, 1600, "Snooker");
    }

    @Override
    boolean isAvailable() {
        return LocalDateTime.now().getHour() >= 18 && isAvailable;
    }
}
