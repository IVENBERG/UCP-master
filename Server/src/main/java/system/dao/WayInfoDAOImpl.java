package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.WayInfo;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WayInfoDAOImpl implements WayInfoDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(WayInfo wayInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(wayInfo);
        logger.info("WayInfo successfully saved.");
    }

    @Override
    public List<WayInfo> getWayInfo() {
        Session session = this.sessionFactory.getCurrentSession();
        List<WayInfo> userWayInfo = session.createQuery("from WayInfo ").list();
        return userWayInfo;
    }

    @Override
    public void update(WayInfo wayInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(wayInfo);
        logger.info("WayInfo successfully update.");
    }

    @Override
    public void remove(WayInfo wayInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        WayInfo currentWayInfo = (WayInfo) session.load(WayInfo.class, new Integer(wayInfo.getId()));
        if(currentWayInfo != null){
            session.delete(currentWayInfo);
        }
        logger.info("WayInfo successfully remuved.");
    }
}
