package system.service;

import system.dao.OrderDAOImpl;
import system.entity.Order;

import java.util.List;

public class OrderLogic {
    public boolean updateOrder(int id, String status){
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        Order order = orderDAO.getOrder(id);
        order.setStatus(status);
        orderDAO.update(order);
        return true;
    }
    public String getOrders(){
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        JsonGenerator jsonGenerator = new JsonGenerator();
        List<Order> orderList = orderDAO.getNewOrders();
        return jsonGenerator.generateAllOrders(orderList);
    }
}
