package system.service;


import org.hibernate.Query;
import org.hibernate.Session;
import system.anotherClass.AnotherClass;
import system.dao.ServiceFormDAO;
import system.entity.ServiceEntity;
import system.entity.ServiceFormEntity;
import system.entity.UsersEntity;
import system.hibernateConfig.SessionUtil;

import java.util.List;

public class ServiceFormService extends SessionUtil implements ServiceFormDAO{
    AnotherClass anotherClass = new AnotherClass();
    public void add(ServiceFormEntity serviceFormEntity){
        openTransactionSession();
        Session session = getSession();
        session.save(serviceFormEntity);
        closeTransactionSession();
    }
    public List<ServiceFormEntity> getAll(){
        openTransactionSession();
        String sql = "SELECT * FROM service_form WHERE id_users ="+ anotherClass.getId_user();
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceFormEntity.class);
        List<ServiceFormEntity> serviceFormEntity = query.list();
        closeTransactionSession();
        return serviceFormEntity;
    }
    public List<ServiceEntity> getS(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id = "+ anotherClass.getIdServ();
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<UsersEntity> getU(){
        openTransactionSession();
        String sql = "SELECT * FROM users WHERE id="+ anotherClass.getId_user();
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(UsersEntity.class);
        List<UsersEntity> usersEntity = query.list();
        closeTransactionSession();
        return usersEntity;
    }
    public List<ServiceFormEntity> getDeleteInformation(){
        openTransactionSession();
        String sql = "SELECT * FROM service_form WHERE id_service ="+ anotherClass.getIdServ();
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceFormEntity.class);
        List<ServiceFormEntity> serviceFormEntity = query.list();
        closeTransactionSession();
        return serviceFormEntity;
    }
    public void remove(ServiceFormEntity serviceFormEntity){
        openTransactionSession();
        Session session = getSession();
        //session.delete(serviceFormEntity);
        Query query = session.createQuery("delete ServiceFormEntity where serviceEntity.id = :ID");
        query.setParameter("ID", anotherClass.getIdServ());
        int result = query.executeUpdate();
        closeTransactionSession();
    }
    public void edit(ServiceFormEntity serviceFormEntity){
        openTransactionSession();
        Session session = getSession();
        session.update(serviceFormEntity);
        closeTransactionSession();
    }
}
