package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.Transport;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransportDAOImpl implements TransportDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Transport transport) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(transport);
        logger.info("Transport successfully saved.");
    }

    @Override
    public List<Transport> getTransport() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Transport> userTransport = session.createQuery("from Transport ").list();
        return userTransport;
    }

    @Override
    public void update(Transport transport) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(transport);
        logger.info("Transport successfully update.");
    }

    @Override
    public void remove(Transport transport) {
        Session session = this.sessionFactory.getCurrentSession();
        Transport currentTransport = (Transport) session.load(Transport.class, new Integer(transport.getIdTransport()));
        if(currentTransport != null){
            session.delete(currentTransport);
        }
        logger.info("Transport successfully remuved.");
    }
}
