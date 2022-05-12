package com.codecool.biliardsaloon.tableType;

public class Pool extends BilliardTable{

    public Pool(TableType type){
        super(type, 1200, "Pool");
    }

    @Override
    boolean isAvailable() {
        return isAvailable;
    }
}
