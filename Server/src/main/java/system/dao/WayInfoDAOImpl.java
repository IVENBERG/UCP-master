package system.dao;

import org.hibernate.Session;
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
