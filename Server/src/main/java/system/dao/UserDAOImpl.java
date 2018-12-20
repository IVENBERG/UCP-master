package system.dao;

import org.hibernate.Query;
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

    public List<User> getUsers() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User").list();
        closeTransactionSession();
        return userList;
    }

    public List<User> getActiveUsers() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User where status = 'active' and role = 'user'").list();
        closeTransactionSession();
        return userList;
    }

    public List<User> getBlockUsers() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User where status = 'block' and role = 'user'").list();
        closeTransactionSession();
        return userList;
    }

    public List<User> getActiveManagers() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User where status = 'active' and role = 'manager'").list();
        closeTransactionSession();
        return userList;
    }

    public List<User> allSeniorManager() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User where status = 'active' and role = 'senior'").list();
        closeTransactionSession();
        return userList;
    }

    public List<User> getBlockManagers() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User where status = 'block' and role = 'manager'").list();
        closeTransactionSession();
        return userList;
    }

    public List<User> getStatusBlockManagers() {
        openTransactionSession();
        Session session = openSession();
        List<User> userList = session.createQuery("from User where role in ('manager', 'senior') and status = 'block'").list();
        closeTransactionSession();
        return userList;
    }

    public User getUser(String login) {
        openTransactionSession();
        Session session = openSession();
        User userPoints = (User) session.createQuery("from User where login = '" + login + "'").uniqueResult();
        closeTransactionSession();
        return userPoints;
    }

    public boolean blockManager(String login) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("update User set status = 'block' where login = '" + login + "'");
        order.executeUpdate();
        closeTransactionSession();
        return true;
    }

    public boolean unblockManager(String login) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("update User set status = 'active' where login = '" + login + "'");
        order.executeUpdate();
        closeTransactionSession();
        return true;
    }

    public boolean upManager(String login) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("update User set role = 'senior' where login = '" + login + "'");
        order.executeUpdate();
        closeTransactionSession();
        return true;
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

    public boolean ubpatePass(String pass, String login) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("update User set password = '" + pass + "' where login = '" + login + "'");
        order.executeUpdate();
        closeTransactionSession();
        return true;
    }

    public boolean upateInfo(String address, String phone, String email, String login) {
        openTransactionSession();
        Session session = openSession();
        Query order = session.createQuery("update User set address = '" + address + "', phone = '"+phone+"', email = '"+email+"' where login = '" + login + "'");
        order.executeUpdate();
        closeTransactionSession();
        return true;
    }
}
