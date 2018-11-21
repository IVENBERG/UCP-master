package system.dao;

import org.hibernate.Session;
import system.entity.User;
import system.hibernateConfig.SessionUtil;

import java.util.List;


public class UserDAOImpl extends SessionUtil implements UserDAO {

    public void add(User user) {
        openTransactionSession();
        Session session = openSession();
        session.save(user);
        closeTransactionSession();
    }

    public List<User> getUser() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User").list();
        closeTransactionSession();
        return userList;
    }

    public void update(User user) {
        openTransactionSession();
        Session session = openSession();
        session.update(user);
        closeTransactionSession();
    }

    public void remove(User user) {
        openTransactionSession();
        Session session = openSession();
        User currentUser = (User) session.load(User.class, new Integer(user.getIdUser()));
        if(currentUser != null){
            session.delete(currentUser);
        }
        closeTransactionSession();
    }
}
