package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.Order;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(order);
        logger.info("Order successfully saved.");
    }

    @Override
    public List<Order> getOrder() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Order> userOrder = session.createQuery("from Order").list();
        return userOrder;
    }

    @Override
    public void update(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(order);
        logger.info("Order successfully update.");
    }

    @Override
    public void remove(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        Order currentOrder = (Order) session.load(Order.class, new Integer(order.getIdOrder()));
        if(currentOrder != null){
            session.delete(currentOrder);
        }
        logger.info("Order successfully remuved.");
    }
}
