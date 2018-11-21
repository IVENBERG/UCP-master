package system.dao;



import system.entity.WayInfo;

import java.util.List;

public interface WayInfoDAO {
    void add(WayInfo wayInfo);
    List<WayInfo> getWayInfo();
    void update(WayInfo wayInfo);
    void remove(WayInfo wayInfo);
}
