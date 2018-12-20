package system.dao;



import system.entity.Orders;

import java.util.List;

public interface OrderDAO {
    void add(Orders order);
    List<Orders> getOrder();
    List<Orders> getUserOrders(int id);
    Orders getOrder(int id);
    boolean update(int id, String status);
    void remove(Orders order);
    List<Orders> getNewOrders();
}
