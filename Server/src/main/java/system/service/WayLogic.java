package system.service;

import org.springframework.http.HttpEntity;
import system.dao.WayDAOImpl;
import system.entity.Way;

import java.util.List;

public class WayLogic {
    public boolean addWay(HttpEntity<String> request){

        return true;
    }
    public boolean deleteWay(int id){
        WayDAOImpl wayDAO = new WayDAOImpl();
        wayDAO.remove(wayDAO.getWayID(id));

        return true;
    }
    /*public String returnAllWays(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayDAOImpl wayDAO = new WayDAOImpl();
        List<Way> pointsList = wayDAO.getWay();
        return jsonGenerator.generateAllPoints(pointsList);
    }*/
}
