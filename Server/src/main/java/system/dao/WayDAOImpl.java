package system.dao;

import org.hibernate.Query;
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
        List<Way> userWay = session.createQuery("from Way").list();
        closeTransactionSession();
        return userWay;
    }

    public List<Way> getWayID(int id) {
        openTransactionSession();
        Session session = openSession();
        List<Way> userWay = session.createQuery("from Way where id_way = " + id).list();
        closeTransactionSession();
        return userWay;
    }

    public void update(Way way) {
        openTransactionSession();
        Session session = openSession();
        session.update(way);
        closeTransactionSession();
    }

    public void remove(int id_way) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("delete Orders where id_way = " + id_way);
        order.executeUpdate();
        Query way = session.createQuery("delete Way where id_way = " + id_way);
        way.executeUpdate();
        Query way_info = session.createQuery("delete WayInfo where id = " + id_way);
        way_info.executeUpdate();
        closeTransactionSession();
    }
}
