package system.dao;


import system.entity.CategoryOfServicesEntity;

import java.sql.SQLException;
import java.util.List;

public interface CategoryOfServicesDAO {
    void add(CategoryOfServicesEntity categoryOfServicesEntity) throws SQLException;
    List<CategoryOfServicesEntity> getAll() throws SQLException;
    void update(CategoryOfServicesEntity categoryOfServicesEntity) throws SQLException;
    void remove(CategoryOfServicesEntity categoryOfServicesEntity) throws SQLException;
}
