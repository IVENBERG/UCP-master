package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.Way;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WayDAOImpl implements WayDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Way way) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(way);
        logger.info("Way successfully saved.");
    }

    @Override
    public List<Way> getWay() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Way> userWay = session.createQuery("from Way ").list();
        return userWay;
    }

    @Override
    public void update(Way way) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(way);
        logger.info("Way successfully update.");
    }

    @Override
    public void remove(Way way) {
        Session session = this.sessionFactory.getCurrentSession();
        Way currentWay = (Way) session.load(Way.class, new Integer(way.getId()));
        if(currentWay != null){
            session.delete(currentWay);
        }
        logger.info("Way successfully remuved.");
    }
}
