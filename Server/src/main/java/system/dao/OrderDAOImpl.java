package system.dao;

import org.hibernate.Session;
import system.entity.Order;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class OrderDAOImpl extends SessionUtil implements OrderDAO {

    public void add(Order order) {
        openTransactionSession();
        Session session = openSession();
        session.save(order);
        closeTransactionSession();
    }

    public List<Order> getOrder() {
        openTransactionSession();
        Session session = openSession();
        List<Order> userOrder = session.createQuery("from Order").list();
        closeTransactionSession();
        return userOrder;
    }

    public List<Order> getNewOrders() {
        openTransactionSession();
        Session session = openSession();
        List<Order> userOrder = session.createQuery("from Order where status = 'new'").list();
        closeTransactionSession();
        return userOrder;
    }

    public Order getOrder(int id) {
        openTransactionSession();
        Session session = openSession();
        Order userOrder = (Order) session.createQuery("from Order where id_order").uniqueResult();
        closeTransactionSession();
        return userOrder;
    }

    public void update(Order order) {
        openTransactionSession();
        Session session = openSession();
        session.update(order);
        closeTransactionSession();
    }

    public void remove(Order order) {
        openTransactionSession();
        Session session = openSession();
        Order currentOrder = (Order) session.load(Order.class, new Integer(order.getIdOrder()));
        if(currentOrder != null){
            session.delete(currentOrder);
        }
        closeTransactionSession();
    }
}
