package ucp.dao;



import ucp.model.Order;

import java.util.List;

public interface OrderDAO {
    void add(Order order);
    List<Order> getOrder();
    void update(Order order);
    void remove(Order order);
}
