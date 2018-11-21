package system.dao;

import org.hibernate.Session;
import system.entity.Lines;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class LinesDAOImpl extends SessionUtil implements LinesDAO {

    public void add(Lines lines) {
        openTransactionSession();
        Session session = openSession();
        session.save(lines);
        closeTransactionSession();
    }

    public List<Lines> getLines() {
        openTransactionSession();
        Session session = openSession();
        List<Lines> linesList = session.createQuery("from Lines ").list();
        closeTransactionSession();
        return linesList;
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
        Lines currentLines = (Lines) session.load(Lines.class, new Integer(lines.getIdLine()));
        if(currentLines != null){
            session.delete(currentLines);
        }
        closeTransactionSession();
    }
}
