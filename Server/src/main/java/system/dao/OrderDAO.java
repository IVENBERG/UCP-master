package system.dao;



import system.entity.Order;

import java.util.List;

public interface OrderDAO {
    void add(Order order);
    List<Order> getOrder();
    Order getOrder(int id);
    void update(Order order);
    void remove(Order order);
    List<Order> getNewOrders();
}
