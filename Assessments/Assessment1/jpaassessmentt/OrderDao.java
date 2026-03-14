package com.demo.jpaassessmentt;

import java.util.List;

public interface OrderDao {

    void addOrder(Order o, int cid);

    Order viewOrderById(int id);

    List<Order> viewOrdersByCustomerName(String name);

}