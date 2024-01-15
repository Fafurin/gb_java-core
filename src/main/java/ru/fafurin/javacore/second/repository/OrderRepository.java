package ru.fafurin.javacore.second.repository;

import ru.fafurin.javacore.second.entity.Order;

import java.util.ArrayList;

public class OrderRepository {

    private ArrayList<Order> orders = new ArrayList<>();


    public void setOrder(Order order) {
        this.orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}
