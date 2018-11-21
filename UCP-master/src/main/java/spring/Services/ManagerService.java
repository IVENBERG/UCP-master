package spring.Services;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ManagerService {
    public String addPoint(JsonNode actualObj){
        String country = actualObj.get("country").textValue();
        String region = actualObj.get("region").textValue();
        String city = actualObj.get("city").textValue();

        if(region.equals(""))
        {
            String name = country+" "+city;
            return name;
        }
        else
        {
            String name = country+" "+region+" "+city;
            return name;
        }
    }
    public String addWay(JsonNode objNode) {
        String point1 = objNode.get("point1").textValue();
        String point2 = objNode.get("point2").textValue();
        double distance = objNode.get("distance").doubleValue();
        String transport = objNode.get("transport").textValue();
        int pos = objNode.get("pos").intValue();

        String way = pos+" "+point1+" "+point2+" "+transport+" "+distance;
        return way;
    }
    public JSONArray allWays() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject = new JSONObject();
            if(i==0)
            {
                jsonObject.put("time","3-5 дней");
                jsonObject.put("cost",12300);
                jsonObject.put("dist",14390);
                jsonObject.put("pointB","Владивосток");
                jsonObject.put("pointA","Минск");
                jsonObject.put("id",1);
            }
            else
            {
                jsonObject.put("pointA","Владивосток");
                jsonObject.put("pointB","Минск");
                jsonObject.put("dist",14390);
                jsonObject.put("cost",12300);
                jsonObject.put("time","3-5 дней");
                jsonObject.put("id",2);
            }
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
