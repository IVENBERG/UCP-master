package system.dao;



import system.entity.WayInfo;

import java.util.List;

public interface WayInfoDAO {
    void add(WayInfo wayInfo);
    List<WayInfo> getWayInfo();
    List<WayInfo> getWayInfo(String point1, String point2);
    void update(WayInfo wayInfo);
    void remove(WayInfo wayInfo);
}
