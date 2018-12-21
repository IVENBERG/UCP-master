package system.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import system.service.JsonGenerator;
import system.service.OrderLogic;
import system.service.PointsLogic;
import system.service.WayLogic;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ManagerController {
    //success
    @RequestMapping(value = "/addpoin", method = RequestMethod.POST)
    public @ResponseBody String addPoint(HttpEntity<String> request) throws IOException, JSONException, SQLException {
        System.out.println(request.toString());
        PointsLogic pointLogic = new PointsLogic();
        JsonGenerator jsonGenerator = new JsonGenerator();
        if(pointLogic.addPoint(request) == true)
        {
            return jsonGenerator.generateSuccessTrueJson();
        }
        else
        {
            return jsonGenerator.generateSuccessFalseJson();
        }
    }
    //success
    @RequestMapping(value = "/addway", method = RequestMethod.POST)
    public @ResponseBody String addWay(HttpEntity<String> request) throws IOException, JSONException, SQLException {
        WayLogic wayClass = new WayLogic();
        if(wayClass.addWay(request)){
            JSONObject response = new JSONObject();
            response.put("success",true);
            return response.toString();
        }
        else{
            JSONObject response = new JSONObject();
            response.put("success",false);
            response.put("message","Такой маршрут уже существует");
            return response.toString();
        }
    }
    //success
    @RequestMapping(value = "/allways", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String allWays() throws JSONException{
        WayLogic wayLogic = new WayLogic();
        return wayLogic.returnAllWays();
    }
    //success
    @RequestMapping(value = "/way/{id}", method = RequestMethod.GET)
    public @ResponseBody String wayId(@PathVariable int id) throws JSONException {
        WayLogic wayLogic = new WayLogic();
        return wayLogic.returnWaysID(id);
    }
    //success
    @RequestMapping(value = "/way/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteWayId(@PathVariable int id) throws JSONException {
        WayLogic wayLogic = new WayLogic();
        return wayLogic.deleteWay(id);
    }
    //success
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public @ResponseBody String viewOrders() throws JSONException {
        OrderLogic orderLogic = new OrderLogic();
        return orderLogic.getOrders();
    }
    //success
    @RequestMapping(value = "/order/{id}/{status}", method = RequestMethod.GET)
    public @ResponseBody String order(@PathVariable int id,@PathVariable String status) throws JSONException {
        JSONObject response = new JSONObject();
        OrderLogic orderLogic = new OrderLogic();
        response.put("success", orderLogic.updateOrder(id, status));
        return response.toString();
    }
    //success
    @RequestMapping(value = "/allPoints", method = RequestMethod.GET)
    public @ResponseBody String getAllPoints() throws JSONException {
        PointsLogic pointsLogic = new PointsLogic();
        return pointsLogic.returnAllPoints();
    }
}
