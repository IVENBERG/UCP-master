package system.service;


import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.UsersDAO;
import system.entity.UsersEntity;
import system.hibernateConfig.SessionUtil;

import java.util.List;

public class UsersService extends SessionUtil implements UsersDAO {
    public void add(UsersEntity usersEntity){
        openTransactionSession();
        Session session = getSession();
        session.save(usersEntity);
        closeTransactionSession();
    }
    public List<UsersEntity> getUser(UsersEntity ue){
        openTransactionSession();
        String sql = "SELECT * FROM users";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(UsersEntity.class);
        List<UsersEntity> usersEntity = query.list();
        closeTransactionSession();
        return usersEntity;
    }
    public void update(UsersEntity usersEntity){
        openTransactionSession();
        Session session = getSession();
        session.update(usersEntity);
        closeTransactionSession();
    }
    public void remove(UsersEntity usersEntity){
        openTransactionSession();
        Session session = getSession();
        session.delete(usersEntity);
        closeTransactionSession();
    }
}
