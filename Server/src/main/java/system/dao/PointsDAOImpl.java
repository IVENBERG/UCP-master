package system.dao;

import org.hibernate.Session;
import system.entity.Points;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class PointsDAOImpl extends SessionUtil implements PointsDAO {

    public void add(Points points) {
        openTransactionSession();
        Session session = openSession();
        session.save(points);
        closeTransactionSession();
    }

    public List<Points> getPoints() {
        openTransactionSession();
        Session session = openSession();
        List<Points> userPoints = session.createQuery("from Points").list();
        closeTransactionSession();
        return userPoints;
    }


    public Points getPointsID(int id) {
        openTransactionSession();
        Session session = openSession();
        Points userPoints = (Points) session.createQuery("from Points where id_point = " + id).uniqueResult();
        closeTransactionSession();
        return userPoints;
    }

    public Points getPointsName(String name) {
        openTransactionSession();
        Session session = openSession();
        Points userPoints = (Points) session.createQuery("from Points where name = '" + name + "'").uniqueResult();
        closeTransactionSession();
        return userPoints;
    }

    public void update(Points points) {
        openTransactionSession();
        Session session = openSession();
        session.update(points);
        closeTransactionSession();
    }

    public void remove(Points points) {
        openTransactionSession();
        Session session = openSession();
        Points currentPoints = (Points) session.load(Points.class, new Integer(points.getIdPoint()));
        if(currentPoints != null){
            session.delete(currentPoints);
        }
        closeTransactionSession();
    }
}
