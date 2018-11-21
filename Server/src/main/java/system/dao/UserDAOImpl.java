package ucp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ucp.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(LinesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
        logger.info("User successfully saved.");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUser() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully update.");
    }

    @Override
    public void remove(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        User currentUser = (User) session.load(User.class, new Integer(user.getIdUser()));
        if(currentUser != null){
            session.delete(currentUser);
        }
        logger.info("User successfully remuved.");
    }
}
