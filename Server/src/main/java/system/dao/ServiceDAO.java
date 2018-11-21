package system.dao;


import system.entity.ServiceEntity;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDAO {
    void add(ServiceEntity serviceEntity) throws SQLException;
    List<ServiceEntity> getAll() throws SQLException;
    void update(ServiceEntity serviceEntity) throws SQLException;
    void remove(ServiceEntity serviceEntity) throws SQLException;
}
