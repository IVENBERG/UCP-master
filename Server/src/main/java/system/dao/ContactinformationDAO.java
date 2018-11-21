package system.dao;

import system.entity.ContactinformationEntity;

import java.sql.SQLException;
import java.util.List;

public interface ContactinformationDAO {
    void add(ContactinformationEntity contactinformationEntity) throws SQLException;
    List<ContactinformationEntity> getAll() throws SQLException;
    void update(ContactinformationEntity contactinformationEntity) throws SQLException;
    void remove(ContactinformationEntity contactinformationEntity) throws SQLException;
}
