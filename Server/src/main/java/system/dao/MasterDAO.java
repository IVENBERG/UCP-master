package system.dao;


import system.entity.MasterEntity;

import java.sql.SQLException;
import java.util.List;

public interface MasterDAO {
    void add(MasterEntity masterEntity) throws SQLException;
    List<MasterEntity> getAll() throws SQLException;
    void update(MasterEntity masterEntity) throws SQLException;
    void remove(MasterEntity masterEntity) throws SQLException;
}
