package system.service;

import org.json.JSONArray;
import org.json.JSONObject;
import system.entity.Points;

import java.util.Iterator;
import java.util.List;

public class JsonGenerator {
    public JSONObject generateObjectForAllPoints(int flag, Points point){
        JSONObject viewPoint = new JSONObject();
        viewPoint.put("id", flag);
        viewPoint.put("value", point.getName());
        return viewPoint;
    }
    public String generateSuccessTrueJson() {
        JSONObject response = new JSONObject();
        response.put("success",true);
        return response.toString();
    }
    public String generateSuccessFalseJson() {
        JSONObject response = new JSONObject();
        response.put("success",false);
        response.put("message","Такая точка уже существует! Валера, иди в жопу!");
        return response.toString();
    }
    public String generateAllPoints(List<Points> pointsList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();

        int flag = 1;
        for (Iterator<Points> it = pointsList.iterator(); it.hasNext(); ) {
            employees.put(generateObjectForAllPoints(flag, it.next()));
            flag++;
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
}
