package system.dao;



import system.entity.Transport;

import java.util.List;

public interface TransportDAO {
    void add(Transport transport);
    List<Transport> getTransport();
    void update(Transport transport);
    void remove(Transport transport);
}
