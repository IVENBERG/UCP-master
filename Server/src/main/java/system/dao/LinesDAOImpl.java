package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import system.entity.Lines;
import system.entity.Orders;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class LinesDAOImpl extends SessionUtil implements LinesDAO {

    public void add(Lines lines) {
        Session session = openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(lines);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public List<Lines> getLines() {
        openTransactionSession();
        Session session = openSession();
        List<Lines> linesList = session.createQuery("from Lines").list();
        closeTransactionSession();
        return linesList;
    }

    public Lines getLine(int start_id, int end_id) {
        openTransactionSession();
        Session session = openSession();
        Lines line = (Lines) session.createQuery("from Lines where start_point = " + start_id + " and end_point = " + end_id).uniqueResult();
        closeTransactionSession();
        return line;
    }

    public void update(Lines lines) {
        openTransactionSession();
        Session session = openSession();
        session.update(lines);
        closeTransactionSession();
    }

    public void remove(Lines lines) {
        openTransactionSession();
        Session session = openSession();
        Lines currentLines = (Lines) session.load(Lines.class, new Integer(lines.getId()));
        if(currentLines != null){
            session.delete(currentLines);
        }
        closeTransactionSession();
    }
}
