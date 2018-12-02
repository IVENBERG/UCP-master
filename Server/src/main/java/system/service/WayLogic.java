package system.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import system.dao.*;
import system.entity.Lines;
import system.entity.Way;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WayLogic {
    public boolean addWay(HttpEntity<String> request){
        Way way = new Way();
        Lines lines = new Lines();
        List<Way> wayList = new ArrayList<Way>();
        PointsDAOImpl pointsDAO = new PointsDAOImpl();
        LinesDAOImpl linesDAO = new LinesDAOImpl();
        TransportDAOImpl transportDAO = new TransportDAOImpl();
        WayDAOImpl wayDAO = new WayDAOImpl();
        WayInfoDAOImpl wayInfoDAO = new WayInfoDAOImpl();
        int flag = 0;

        List<Lines> linesList = linesDAO.getLines();

        JSONObject jsonObject = new JSONObject(request);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObj = (JSONObject) iterator.next();
            lines.setStartPoint(pointsDAO.getPointsName(jsonObj.getString("point1")));
            lines.setEndPoint(pointsDAO.getPointsName(jsonObj.getString("point2")));
            flag = 0;

            for(Lines line : linesList){
                if(line.getStartPoint().equals(lines.getStartPoint()) && line.getEndPoint().equals(lines.getEndPoint())){
                    flag ++;
                }
            }

            if(flag == 0){
                lines.setTransport(transportDAO.getTransportName(jsonObj.getString("transport")));
                lines.setDistance(jsonObj.getInt("distance"));

                linesDAO.add(lines);
                way.setLine(lines);
                way.setPosition(jsonObj.getInt("pos"));
                wayList.add(way);
            }

        }
        wayDAO.add(way);

        return true;
    }
    public String deleteWay(int id){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayDAOImpl wayDAO = new WayDAOImpl();
        wayDAO.remove(id);
        return jsonGenerator.generateSuccessTrueJson();
    }
    public String returnAllWays(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayDAOImpl wayDAO = new WayDAOImpl();
        List<Way> pointsList = wayDAO.getWay();
        return jsonGenerator.generateAllWays(pointsList);
    }
    public String returnWaysID(int id){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayDAOImpl wayDAO = new WayDAOImpl();
        List<Way> pointsList = wayDAO.getWayID(id);
        return jsonGenerator.generateAllWays(pointsList);
    }
}
