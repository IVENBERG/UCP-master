package ucp.dao;



import ucp.model.WayInfo;

import java.util.List;

public interface WayInfoDAO {
    void add(WayInfo wayInfo);
    List<WayInfo> getWayInfo();
    void update(WayInfo wayInfo);
    void remove(WayInfo wayInfo);
}
