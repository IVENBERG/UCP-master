package system.dao;




import system.entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> getUser();
    void update(User user);
    void remove(User user);
}
