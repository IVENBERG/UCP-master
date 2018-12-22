package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import system.entity.Orders;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class OrderDAOImpl extends SessionUtil implements OrderDAO {
    String newStr = "newOrder";

    public void add(Orders order) {
        openTransactionSession();
        Session session = openSession();
        session.save(order);
        closeTransactionSession();
    }

    public List<Orders> getOrder() {
        openTransactionSession();
        Session session = openSession();
        List<Orders> userOrder = session.createQuery("from Orders").list();
        closeTransactionSession();
        return userOrder;
    }

    public List<Orders> getUserOrders(int id) {
        openTransactionSession();
        Session session = openSession();
        List<Orders> userOrder = session.createQuery("from Orders where id_user = " + id).list();
        closeTransactionSession();
        return userOrder;
    }

    public List<Orders> getNewOrders() {
        openTransactionSession();
        Session session = openSession();
        List<Orders> userOrder = session.createQuery("from Orders where status = 'new'").list();
        closeTransactionSession();
        return userOrder;
    }

    public Orders getOrder(int id) {
        openTransactionSession();
        Session session = openSession();
        Orders userOrder = (Orders) session.createQuery("from Orders where id_order = " + id).uniqueResult();
        closeTransactionSession();
        return userOrder;
    }

    public boolean update(int id, String status) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("update Orders set status = '" + status + "' where id_order = " + id);
        order.executeUpdate();
        closeTransactionSession();
        return true;
    }

    public void remove(Orders order) {
        openTransactionSession();
        Session session = openSession();
        Orders currentOrder = (Orders) session.load(Orders.class, new Integer(order.getIdOrder()));
        if(currentOrder != null){
            session.delete(currentOrder);
        }
        closeTransactionSession();
    }
}
