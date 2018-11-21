package system.service;


import org.hibernate.Query;
import org.hibernate.Session;
import system.entity.ContactinformationEntity;
import system.hibernateConfig.SessionUtil;
import system.dao.ContactinformationDAO;

import java.util.List;

public class ContactinformationService extends SessionUtil implements ContactinformationDAO{
    public void add(ContactinformationEntity contactinformationEntity){
        openTransactionSession();
        Session session = getSession();
        session.save(contactinformationEntity);
        closeTransactionSession();
    }
    public List<ContactinformationEntity> getAll(){
        openTransactionSession();
        String sql = "SELECT * FROM contactinformation";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(ContactinformationEntity.class);
        List<ContactinformationEntity> ContactinformationEntityList = query.list();
        closeTransactionSession();
        return ContactinformationEntityList;
    }
    public void update(ContactinformationEntity contactinformationEntity){
        openTransactionSession();
        Session session = getSession();
        session.update(contactinformationEntity);
        closeTransactionSession();
    }
    public void remove(ContactinformationEntity contactinformationEntity){
        openTransactionSession();
        Session session = getSession();
        session.delete(contactinformationEntity);
        closeTransactionSession();
    }
}
