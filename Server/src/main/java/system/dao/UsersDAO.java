package system.dao;


import system.entity.UsersEntity;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    void add(UsersEntity usersEntity) throws SQLException;
    List<UsersEntity> getUser(UsersEntity ue) throws SQLException;
    void update(UsersEntity usersEntity) throws SQLException;
    void remove(UsersEntity usersEntity) throws SQLException;
}
