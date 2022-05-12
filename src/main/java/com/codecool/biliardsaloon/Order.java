package com.codecool.biliardsaloon;

import com.codecool.biliardsaloon.tableType.BilliardTable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String orderId;
    private List<Consumable> orderList;
    private BilliardTable table;
    protected LocalDateTime startGameAt;
    protected LocalDateTime endGameAt;

    public Order(BilliardTable table){
        this.table = table;
        this.orderId = UUID.randomUUID().toString();
        this.startGameAt = LocalDateTime.now().minusHours(5);;
        setStartGameAt();
    }

    public void orderConsumable(Consumable consumable){
        if (orderList == null) {
            orderList = new ArrayList<>();
        }
        orderList.add(consumable);
    }


    public void stopPlaying(){
        endGameAt = LocalDateTime.now();
        table.release();
    }

    public int calculateTablePrice(){
        return howManyHours() * table.getPricePerHour() ;
    }

    public int calculateConsumablePrice(){
        int consumablePrice = 0;
        for(Consumable consumable: orderList){
            consumablePrice += consumable.getPrice();
        }
        return consumablePrice;
    }

    public int totalPrice(){
        return calculateTablePrice() + calculateConsumablePrice();
    }

    public int howManyHours(){
        return (int) (Duration.between(startGameAt, LocalDateTime.now()).toHours());
    }

    public StringBuilder consumableList(){
        StringBuilder cl = new StringBuilder();
        for(Consumable consumable: orderList){
            cl.append(consumable.getName());
            cl.append(" - ");
            cl.append(consumable.getPrice());
            cl.append(", ");
        }
        return cl;
    }

    @Override
    public String toString() {
        return "Order id: " + orderId + "\n" +
                "table = " + table.getName() + "\n" +
                "hours = " + howManyHours() + "\n" +
                "table price = " + calculateTablePrice() + "\n" +
                "orderList = " + consumableList() + "\n" +
                "consumable price = " + calculateConsumablePrice() + "\n" +
                "TOTAL = " + totalPrice() + "\n";
    }
}
