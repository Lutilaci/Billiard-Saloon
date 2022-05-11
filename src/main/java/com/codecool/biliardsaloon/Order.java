package com.codecool.biliardsaloon;

import com.codecool.biliardsaloon.tableType.BilliardTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    private int orderId = 1;
    private List<Consumable> orderList;
    private BilliardTable table;
    protected int startGameAt;
    protected int endGameAt;
    int low = 1;
    int high = 5;

    public Order(BilliardTable table){
        this.table = table;
        this.orderId++;
        setStartGameAt();
    }

    public void orderConsumable(Consumable consumable){
        if (orderList == null) {
            orderList = new ArrayList<>();
        }
        orderList.add(consumable);
    }

    public void setStartGameAt() {
        Random random = new Random();
        this.startGameAt = random.nextInt(low);
    }

    public void setEndGameAt(){
        Random random = new Random();
        this.endGameAt = random.nextInt(high-low) + low;
    }

    public void stopPlaying(){
        setEndGameAt();
        table.setAvailable();
    }

    public int calculateTablePrice(){
        int price = (endGameAt - startGameAt) * table.getPricePerHour() ;
        return price;
    }

    public int calculateConsumablePrice(){
        int consumablePrice = 0;
        for(Consumable consumable: orderList){
            consumablePrice += consumable.price;
        }
        return consumablePrice;
    }

    public int totalPrice(){
        return calculateTablePrice() + calculateConsumablePrice();
    }

    public int howManyHours(){
        return endGameAt - startGameAt;
    }

    public StringBuilder consumableList(){
        StringBuilder cl = new StringBuilder();
        for(Consumable consumable: orderList){
            cl.append(consumable.name);
            cl.append(" - ");
            cl.append(consumable.price);
            cl.append(", ");
        }
        return cl;
    }

    @Override
    public String toString() {
        return "Order no.: " + orderId + "\n" +
                "table = " + table + "\n" +
                "hours = " + howManyHours() + "\n" +
                "table price = " + calculateTablePrice() + "\n" +
                "orderList = " + consumableList() + "\n" +
                "consumable price = " + calculateConsumablePrice() + "\n" +
                "TOTAL = " + totalPrice() + "\n";
    }
}
