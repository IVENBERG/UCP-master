package system.service;


import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.ServiceDAO;
import system.entity.ServiceEntity;
import system.hibernateConfig.SessionUtil;

import java.util.List;

public class ServiceService extends SessionUtil implements ServiceDAO{
    public void add(ServiceEntity serviceEntity){
        openTransactionSession();
        Session session = getSession();
        session.save(serviceEntity);
        closeTransactionSession();
    }
    public List<ServiceEntity> getAll(){
        openTransactionSession();
        String sql = "SELECT * FROM service";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getNail(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 1";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getHair(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 2";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getSpa(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 3";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getKosm(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 4";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getDepil(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 5";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getBrow(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 6";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getPerm(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 7";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public List<ServiceEntity> getMakeup(){
        openTransactionSession();
        String sql = "SELECT * FROM service WHERE id_category = 8";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ServiceEntity.class);
        List<ServiceEntity> serviceEntity = query.list();
        closeTransactionSession();
        return serviceEntity;
    }
    public void update(ServiceEntity serviceEntity){
        openTransactionSession();
        Session session = getSession();
        session.update(serviceEntity);
        closeTransactionSession();
    }
    public void remove(ServiceEntity serviceEntity){
        openTransactionSession();
        Session session = getSession();
        session.delete(serviceEntity);
        closeTransactionSession();
    }
}
