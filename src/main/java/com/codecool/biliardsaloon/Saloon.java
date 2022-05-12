package com.codecool.biliardsaloon;

import com.codecool.biliardsaloon.tableType.*;

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
        Pool poolTable = new Pool(TableType.POOL);
        this.poolTable = poolTable;
        Rex rexTable = new Rex(TableType.REX);
        this.rexTable = rexTable;
        Snooker snookerTable = new Snooker(TableType.SNOOKER);
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
        order.orderConsumable(new Consumable("Dreher", ConsumableType.BEVERAGE, 900));
        order.orderConsumable(new Consumable("Gösser", ConsumableType.BEVERAGE, 700));
        closeOrder(order, rexTable);
        System.out.println(order.toString());
    }

    private void order2() {
        Order order = new Order(snookerTable);
        openedOrders.add(order);
        order.orderConsumable(new Consumable("Heineken", ConsumableType.BEVERAGE, 1100));
        order.orderConsumable(new Consumable("Gyros", ConsumableType.FOOD, 1800));
        closeOrder(order, snookerTable);
        System.out.println(order.toString());
    }

    private void order3() {
        Order order = new Order(poolTable);
        openedOrders.add(order);
        order.orderConsumable(new Consumable("Pizza", ConsumableType.FOOD, 2500));
        order.orderConsumable(new Consumable("GinTonic", ConsumableType.BEVERAGE, 3000));
        closeOrder(order, poolTable);
        System.out.println(order.toString());
    }

    private void openOrder(BilliardTable table, Order order){
        openedOrders.add(order);
        table.reserve();
    }

    private void closeOrder(Order order, BilliardTable table){
        order.stopPlaying();
        openedOrders.remove(order);
        closedOrders.add(order);
        table.release();
    }
}
