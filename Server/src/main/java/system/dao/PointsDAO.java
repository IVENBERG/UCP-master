package ucp.dao;



import ucp.model.Points;

import java.util.List;

public interface PointsDAO {
    void add(Points points);
    List<Points> getPoints();
    void update(Points points);
    void remove(Points points);
}
