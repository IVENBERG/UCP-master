package system.service;


import org.hibernate.Query;
import org.hibernate.Session;
import system.dao.MasterDAO;
import system.entity.MasterEntity;
import system.hibernateConfig.SessionUtil;

import java.util.List;

public class MasterService extends SessionUtil implements MasterDAO{
    public void add(MasterEntity masterEntity){
        openTransactionSession();
        Session session = getSession();
        session.save(masterEntity);
        closeTransactionSession();
    }


    public List<MasterEntity> getAll(){
        openTransactionSession();
        String sql = "SELECT * FROM master";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(MasterEntity.class);
        List<MasterEntity> masterEntity = query.list();
        closeTransactionSession();
        return masterEntity;
    }


    public void update(MasterEntity masterEntity){
        openTransactionSession();
        Session session = getSession();
        session.update(masterEntity);
        closeTransactionSession();
    }
    public void remove(MasterEntity masterEntity){
        openTransactionSession();
        Session session = getSession();
        session.delete(masterEntity);
        closeTransactionSession();
    }
}
