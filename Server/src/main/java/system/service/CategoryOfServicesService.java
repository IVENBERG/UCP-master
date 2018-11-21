package system.service;


import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.CategoryOfServicesDAO;
import system.entity.CategoryOfServicesEntity;
import system.hibernateConfig.SessionUtil;

import java.util.List;

public class CategoryOfServicesService extends SessionUtil implements CategoryOfServicesDAO{
    public void add(CategoryOfServicesEntity categoryOfServicesEntity){
        openTransactionSession();
        Session session = getSession();
        session.save(categoryOfServicesEntity);
        closeTransactionSession();
    }
    public List<CategoryOfServicesEntity> getAll(){
        openTransactionSession();
        String sql = "SELECT * FROM category_of_services";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(CategoryOfServicesEntity.class);
        List<CategoryOfServicesEntity> categoryOfServicesEntityList = query.list();
        closeTransactionSession();
        return categoryOfServicesEntityList;
    }
    public void update(CategoryOfServicesEntity categoryOfServicesEntity){
        openTransactionSession();
        Session session = getSession();
        session.update(categoryOfServicesEntity);
        closeTransactionSession();
    }
    public void remove(CategoryOfServicesEntity categoryOfServicesEntity){
        openTransactionSession();
        Session session = getSession();
        session.delete(categoryOfServicesEntity);
        closeTransactionSession();
    }
}
