package system.service;

import system.dao.OrderDAOImpl;
import system.entity.Orders;

import java.util.List;

public class OrderLogic {
    public boolean updateOrder(int id, String status){
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        if(orderDAO.update(id, status)){
            return true;
        }
        return false;
    }
    public String getOrders(){
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        JsonGenerator jsonGenerator = new JsonGenerator();
        List<Orders> orderList = orderDAO.getNewOrders();
        return jsonGenerator.generateAllOrders(orderList);
    }
}
