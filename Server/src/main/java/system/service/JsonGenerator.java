package system.service;

import org.json.JSONArray;
import org.json.JSONObject;
import system.entity.Order;
import system.entity.Points;
import system.entity.Way;

import java.util.Iterator;
import java.util.List;

public class JsonGenerator {
    /*public JSONObject generateObjectForAllWays(int flag, Way way){
        JSONObject viewPoint = new JSONObject();
        viewPoint.put("id", flag);
        viewPoint.put("value", way.getName());
        viewPoint.put("value", way.);
        viewPoint.put("value", way.getName());
        return viewPoint;
    }*/
    public JSONObject generateObjectForAllOrder(int flag, Order order){
        JSONObject viewPoint = new JSONObject();
        viewPoint.put("id", order.getIdOrder());
        viewPoint.put("time", order.getTime());
        viewPoint.put("idWay", order.getWay());
        viewPoint.put("price", order.getPrice());
        viewPoint.put("client", order.getUser().getIdUser());
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

        for (Iterator<Points> it = pointsList.iterator(); it.hasNext(); ) {
            employees.put(it.next().getName());
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
    /*public String generateAllWays(List<Way> wayList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();

        int flag = 1;
        for (Iterator<Points> it = wayList.iterator(); it.hasNext(); ) {
            employees.put(generateObjectForAllWays(flag, it.next()));
            flag++;
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }*/
    public String generateAllOrders(List<Order> orderList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();

        int flag = 1;
        for (Iterator<Order> it = orderList.iterator(); it.hasNext(); ) {
            employees.put(generateObjectForAllOrder(flag, it.next()));
            flag++;
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
}