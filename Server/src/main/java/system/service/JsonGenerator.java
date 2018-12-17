package system.service;

import org.json.JSONArray;
import org.json.JSONObject;
import system.entity.Orders;
import system.entity.Points;
import system.entity.User;
import system.entity.Way;

import java.util.Iterator;
import java.util.List;

public class JsonGenerator {
    public JSONObject generateObjectForAllWays(Way way){
        JSONObject viewPoint = new JSONObject();
        viewPoint.put("id", way.getPosition());
        viewPoint.put("pointA", way.getLine().getStartPoint().getName());
        viewPoint.put("pointB", way.getLine().getEndPoint().getName());
        viewPoint.put("dist", way.getLine().getDistance());
        viewPoint.put("cost", 20202002);
        double time = way.getLine().getDistance() / way.getLine().getTransport().getSpeed();
        viewPoint.put("time", time);
        return viewPoint;
    }
    public JSONObject generateObjectForWay(Way way){
        JSONObject viewPoint = new JSONObject();
        viewPoint.put("pos", way.getPosition());
        viewPoint.put("firstpoint", way.getLine().getStartPoint().getName());
        viewPoint.put("secondpoint", way.getLine().getEndPoint().getName());
        viewPoint.put("distance", way.getLine().getDistance());
        viewPoint.put("transport", way.getLine().getTransport().getType());
        return viewPoint;
    }
    public JSONObject generateObjectForAllOrder(Orders order){
        JSONObject viewPoint = new JSONObject();
        viewPoint.put("id", order.getIdOrder());
        viewPoint.put("time", order.getTime());
        viewPoint.put("idWay", order.getWay().getId());
        viewPoint.put("price", order.getPrice());
        viewPoint.put("client", order.getUser().getLogin());
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
    public String generateAllUsers(List<User> userList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();
        JSONObject object = new JSONObject();

        for (Iterator<User> it = userList.iterator(); it.hasNext(); ) {
            User user = it.next();
            String names = user.getSurname() + " " + user.getName();
            object.put("login", user.getLogin());
            object.put("fio", names);

            employees.put(object);
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
    public String generateStatusBlockManagers(List<User> userList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();
        JSONObject object = new JSONObject();

        for (Iterator<User> it = userList.iterator(); it.hasNext(); ) {
            User user = it.next();
            String names = user.getSurname() + " " + user.getName();
            object.put("login", user.getLogin());
            object.put("fio", names);
            object.put("role", user.getRole());

            employees.put(object);
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
    public String generateUser(User user){
        JSONObject response = new JSONObject();

        response.put("success",true);
        response.put("lastName",user.getSurname());
        response.put("firstName",user.getName());
        response.put("secondName","");
        response.put("address",user.getAddress());
        response.put("phone",user.getPhone());
        response.put("email",user.getEmail());

        return response.toString();
    }
    public String generateAllWays(List<Way> wayList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();

        for (Iterator<Way> it = wayList.iterator(); it.hasNext(); ) {
            employees.put(generateObjectForAllWays(it.next()));
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
    public String generateWay(List<Way> wayList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();

        for (Iterator<Way> it = wayList.iterator(); it.hasNext(); ) {
            employees.put(generateObjectForWay(it.next()));
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
    public String generateAllOrders(List<Orders> orderList){
        JSONArray employees = new JSONArray();
        JSONObject response = new JSONObject();

        for (Iterator<Orders> it = orderList.iterator(); it.hasNext(); ) {
            employees.put(generateObjectForAllOrder(it.next()));
        }
        response.put("success",true);
        response.put("data",employees);

        return response.toString();
    }
}