package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import system.entity.Points;
import system.entity.User;
import system.entity.WayInfo;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class WayInfoDAOImpl extends SessionUtil implements WayInfoDAO {

    public void add(WayInfo wayInfo) {
        openTransactionSession();
        Session session = openSession();
        session.save(wayInfo);
        closeTransactionSession();
    }

    @Override
    public List<WayInfo> getWayInfo() {
        openTransactionSession();
        Session session = openSession();
        List<WayInfo> userWayInfo = session.createQuery("from WayInfo ").list();
        closeTransactionSession();
        return userWayInfo;
    }

    public WayInfo getID(Points start, Points end) {
        openTransactionSession();
        Session session = openSession();
        Query query = session.createQuery("from WayInfo where start_point = " + start.getIdPoint() + " and end_point = " + end.getIdPoint());
        if(query.list().isEmpty()){
            closeTransactionSession();
            return null;
        }
        else{
            closeTransactionSession();
            WayInfo wi = (WayInfo) query.uniqueResult();
            return wi;
        }

    }

    @Override
    public List<WayInfo> getWayInfo(String point1, String point2) {
        openTransactionSession();
        Session session = openSession();
        List<WayInfo> userWayInfo = session.createQuery("from WayInfo where start = '"+point1+"' and end = '"+point2+"'").list();
        closeTransactionSession();
        return userWayInfo;
    }

    @Override
    public void update(WayInfo wayInfo) {
        openTransactionSession();
        Session session = openSession();
        session.update(wayInfo);
        closeTransactionSession();
    }

    @Override
    public void remove(WayInfo wayInfo) {
        openTransactionSession();
        Session session = openSession();
        WayInfo currentWayInfo = (WayInfo) session.load(WayInfo.class, new Integer(wayInfo.getId()));
        if(currentWayInfo != null){
            session.delete(currentWayInfo);
        }
        closeTransactionSession();
    }
}
