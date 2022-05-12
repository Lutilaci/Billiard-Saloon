package com.codecool.biliardsaloon.tableType;

import java.time.LocalDateTime;

public class Rex extends BilliardTable{

    public Rex(TableType type) {
        super(type, 800, "Rex");
    }

    @Override
    boolean isAvailable() {
        return LocalDateTime.now().getHour() >= 18 && isAvailable;
    }
}
