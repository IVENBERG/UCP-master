package system.dao;




import system.entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> getUsers();
    User getUser(String login);
    List<User> getActiveUsers();
    List<User> getBlockUsers();
    List<User> getActiveManagers();
    List<User> getBlockManagers();
    List<User> getStatusBlockManagers();
    List<User> allSeniorManager();
    boolean blockManager(String login);
    boolean unblockManager(String login);
    boolean upManager(String login);
    void remove(User user);
}
