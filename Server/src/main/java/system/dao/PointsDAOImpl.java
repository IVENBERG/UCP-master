package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.Points;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PointsDAOImpl implements PointsDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Points points) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(points);
        logger.info("Point successfully saved.");
    }

    @Override
    public List<Points> getPoints() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Points> userPoints = session.createQuery("from Points ").list();
        return userPoints;
    }

    @Override
    public void update(Points points) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(points);
        logger.info("Point successfully update.");
    }

    @Override
    public void remove(Points points) {
        Session session = this.sessionFactory.getCurrentSession();
        Points currentPoints = (Points) session.load(Points.class, new Integer(points.getIdPoint()));
        if(currentPoints != null){
            session.delete(currentPoints);
        }
        logger.info("Point successfully remuved.");
    }
}
