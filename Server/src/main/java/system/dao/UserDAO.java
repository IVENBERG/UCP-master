package ucp.dao;




import ucp.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> getUser();
    void update(User user);
    void remove(User user);
}
