package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.Lines;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LinesDAOImpl implements LinesDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Lines lines) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(lines);
        logger.info("Line successfully saved.");
    }

    @Override
    public List<Lines> getLines() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lines> linesList = session.createQuery("from Lines ").list();
        return linesList;
    }

    @Override
    public void update(Lines lines) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(lines);
        logger.info("Line successfully update.");
    }

    @Override
    public void remove(Lines lines) {
        Session session = this.sessionFactory.getCurrentSession();
        Lines currentLines = (Lines) session.load(Lines.class, new Integer(lines.getIdLine()));
        if(currentLines != null){
            session.delete(currentLines);
        }
        logger.info("Line successfully remuved.");
    }
}
