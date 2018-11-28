package system.dao;

import org.hibernate.Session;
import system.entity.Way;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class WayDAOImpl extends SessionUtil implements WayDAO {

    public void add(Way way) {
        openTransactionSession();
        Session session = openSession();
        session.save(way);
        closeTransactionSession();
    }

    public List<Way> getWay() {
        openTransactionSession();
        Session session = openSession();
        List<Way> userWay = session.createQuery("from Way ").list();
        closeTransactionSession();
        return userWay;
    }

    public Way getWayID(int id) {
        openTransactionSession();
        Session session = openSession();
        Way userWay = (Way) session.createQuery("from Way where Way.id = " + id);
        closeTransactionSession();
        return userWay;
    }

    public void update(Way way) {
        openTransactionSession();
        Session session = openSession();
        session.update(way);
        closeTransactionSession();
    }

    public void remove(Way way) {
        openTransactionSession();
        Session session = openSession();
        Way currentWay = (Way) session.load(Way.class, new Integer(way.getId()));
        if(currentWay != null){
            session.delete(currentWay);
        }
        closeTransactionSession();
    }
}
