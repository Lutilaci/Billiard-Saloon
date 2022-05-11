package com.codecool.biliardsaloon;

import com.codecool.biliardsaloon.tableType.BilliardTable;
import com.codecool.biliardsaloon.tableType.Pool;
import com.codecool.biliardsaloon.tableType.Rex;
import com.codecool.biliardsaloon.tableType.Snooker;

import java.util.ArrayList;
import java.util.List;

public class Saloon {

    public List<BilliardTable> tables;
    public List<Order> closedOrders;
    public List<Order> openedOrders;
    public BilliardTable poolTable;
    public BilliardTable rexTable;
    public BilliardTable snookerTable;

    public Saloon(){
        tables = new ArrayList<>();
        openedOrders = new ArrayList<>();
        closedOrders = new ArrayList<>();
        Pool poolTable = new Pool("Pool");
        this.poolTable = poolTable;
        Rex rexTable = new Rex("Rex");
        this.rexTable = rexTable;
        Snooker snookerTable = new Snooker("Snooker");
        this.snookerTable = snookerTable;
        tables.add(poolTable);
        tables.add(rexTable);
        tables.add(snookerTable);
    }

    public void makeOrder() {
        order1();
        order2();
        order3();
    }

    private void order1() {
        Order order = new Order(rexTable);
        openOrder(rexTable, order);
        order.orderConsumable(new Consumable("Dreher", "drink", 900));
        order.orderConsumable(new Consumable("Gösser", "drink", 700));
        closeOrder(order, rexTable);
        System.out.println(order.toString());
    }

    private void order2() {
        Order order = new Order(snookerTable);
        openedOrders.add(order);
        snookerTable.setAvailable();
        order.orderConsumable(new Consumable("Heineken", "drink", 1100));
        order.orderConsumable(new Consumable("Gyros", "drink", 1800));
        closeOrder(order, snookerTable);
        System.out.println(order.toString());
    }

    private void order3() {
        Order order = new Order(poolTable);
        openedOrders.add(order);
        order.orderConsumable(new Consumable("Pizza", "drink", 2500));
        order.orderConsumable(new Consumable("GinTonic", "drink", 3000));
        closeOrder(order, poolTable);
        System.out.println(order.toString());
    }

    private void openOrder(BilliardTable table, Order order){
        openedOrders.add(order);
        table.setAvailable();
    }

    private void closeOrder(Order order, BilliardTable table){
        order.stopPlaying();
        openedOrders.remove(order);
        closedOrders.add(order);
        table.setAvailable();
    }
}
