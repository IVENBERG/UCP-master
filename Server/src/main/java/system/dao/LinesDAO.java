package system.dao;



import system.entity.Lines;

import java.util.List;

public interface LinesDAO {
    void add(Lines lines);
    List<Lines> getLines();
    void update(Lines lines);
    void remove(Lines lines);
}
