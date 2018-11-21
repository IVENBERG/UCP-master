package system.dao;


import system.entity.ServiceEntity;
import system.entity.ServiceFormEntity;
import system.entity.UsersEntity;

import java.sql.SQLException;
import java.util.List;

public interface ServiceFormDAO {
    void add(ServiceFormEntity serviceEntity) throws SQLException;
    List<ServiceFormEntity> getAll() throws SQLException;
    List<ServiceEntity> getS() throws SQLException;
    List<UsersEntity> getU() throws SQLException;
    List<ServiceFormEntity> getDeleteInformation() throws SQLException;
    void remove(ServiceFormEntity serviceEntity) throws SQLException;
    void edit(ServiceFormEntity serviceEntity) throws SQLException;
}
