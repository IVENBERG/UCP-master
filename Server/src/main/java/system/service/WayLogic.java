package system.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import system.dao.*;
import system.entity.Lines;
import system.entity.Points;
import system.entity.Way;
import system.entity.WayInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class WayLogic {
    public boolean addWay(HttpEntity<String> request){
        int flag = 0;
        Vector<Lines> myVector = new Vector<Lines>();
        Way way = new Way();
        WayInfo wayInfo = new WayInfo();
        Lines lines = new Lines();
        List<Way> wayList = new ArrayList<Way>();
        double sum = 0;

        PointsDAOImpl pointsDAO = new PointsDAOImpl();
        LinesDAOImpl linesDAO = new LinesDAOImpl();
        TransportDAOImpl transportDAO = new TransportDAOImpl();
        WayDAOImpl wayDAO = new WayDAOImpl();
        WayInfoDAOImpl wayInfoDAO = new WayInfoDAOImpl();

        JSONObject jsonObject = new JSONObject(request);
        JSONObject jObject = new JSONObject(jsonObject.get("body").toString());
        JSONArray jsonArray = (JSONArray) jObject.get("data");

        Iterator iterator = jsonArray.iterator();

        while (iterator.hasNext()) {
            JSONObject jsonObj = (JSONObject) iterator.next();
            Points startPoint = pointsDAO.getPointsName(jsonObj.getString("point1"));
            Points endPoint = pointsDAO.getPointsName(jsonObj.getString("point2"));
            Lines new_line = linesDAO.getLine(startPoint.getIdPoint(), endPoint.getIdPoint());
            if(new_line == null){
                Lines line = new Lines();
                line.setStartPoint(startPoint);
                line.setEndPoint(endPoint);
                int distance = jsonObj.getInt("distance");
                sum = sum + distance;
                line.setDistance(distance);
                line.setTransport(transportDAO.getTransportName(jsonObj.getString("transport")));
                linesDAO.add(line);
                myVector.addElement(line);
                flag ++;
            }
            else{
                myVector.addElement(new_line);
            }
        }
        WayInfo id = wayInfoDAO.getID(myVector.firstElement().getStartPoint(), myVector.lastElement().getEndPoint());
        if(id == null){
            wayInfo.setStart_point(myVector.firstElement().getStartPoint());
            wayInfo.setEnd_point(myVector.lastElement().getEndPoint());
            wayInfo.setDistance(sum);
            wayInfoDAO.add(wayInfo);
            id = wayInfoDAO.getID(myVector.firstElement().getStartPoint(), myVector.lastElement().getEndPoint());
            flag++;
        }
        if(flag == 0){
            return false;
        }
        else{
            for(int i = 0; i < myVector.size(); i++){
                way.setPosition(i+1);
                way.setLine(linesDAO.getLine(myVector.get(i).getStartPoint().getIdPoint(), myVector.get(i).getEndPoint().getIdPoint()));
                way.setWayInfo(id);
                wayDAO.add(way);
            }
            return true;
        }
    }
    public String deleteWay(int id){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayDAOImpl wayDAO = new WayDAOImpl();
        wayDAO.remove(id);
        return jsonGenerator.generateSuccessTrueJson();
    }
    public String returnAllWays(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayInfoDAOImpl wayDAO = new WayInfoDAOImpl();
        List<WayInfo> pointsList = wayDAO.getWayInfo();
        return jsonGenerator.generateAllWays(pointsList);
    }
    public String returnWaysID(int id){
        JsonGenerator jsonGenerator = new JsonGenerator();
        WayDAOImpl wayDAO = new WayDAOImpl();
        List<Way> pointsList = wayDAO.getWayID(id);
        return jsonGenerator.generateWay(pointsList);
    }
}
