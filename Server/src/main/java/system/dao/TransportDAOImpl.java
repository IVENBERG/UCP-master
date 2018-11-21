package system.dao;

import org.hibernate.Session;
import system.entity.Transport;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class TransportDAOImpl extends SessionUtil implements TransportDAO {

    public void add(Transport transport) {
        openTransactionSession();
        Session session = openSession();
        session.save(transport);
        closeTransactionSession();
    }

    public List<Transport> getTransport() {
        openTransactionSession();
        Session session = openSession();
        List<Transport> userTransport = session.createQuery("from Transport ").list();
        closeTransactionSession();
        return userTransport;
    }

    public void update(Transport transport) {
        openTransactionSession();
        Session session = openSession();
        session.update(transport);
        closeTransactionSession();
    }

    public void remove(Transport transport) {
        openTransactionSession();
        Session session = openSession();
        Transport currentTransport = (Transport) session.load(Transport.class, new Integer(transport.getIdTransport()));
        if(currentTransport != null){
            session.delete(currentTransport);
        }
        closeTransactionSession();
    }
}
