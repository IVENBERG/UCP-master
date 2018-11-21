package system.dao;



import system.entity.Way;

import java.util.List;

public interface WayDAO {
    void add(Way way);
    List<Way> getWay();
    void update(Way way);
    void remove(Way way);
}
