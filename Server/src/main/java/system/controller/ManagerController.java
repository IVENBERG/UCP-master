package ucp.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ucp.logic.JsonGenerator;
import ucp.logic.PointsLogic;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ManagerController {



    @RequestMapping(value = "/addpoin", method = RequestMethod.POST)
    public @ResponseBody String addPoint(HttpEntity<String> request) throws IOException, JSONException, SQLException {
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

    @RequestMapping(value = "/addway", method = RequestMethod.POST)
    public @ResponseBody String addWay(HttpEntity<String> request) throws IOException, JSONException, SQLException {
        /*WayClass wayClass = new WayClass();
        if(wayClass.addWay(request)){
            JSONObject response = new JSONObject();
            response.put("success",true);

            return response.toString();
        }
        else{
            JSONObject response = new JSONObject();
            response.put("success",false);

            return response.toString();
        }*/
        return "";
    }

    @RequestMapping(value = "/allways", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String allWays() throws JSONException{

        JSONArray jsonArray;
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    @RequestMapping(value = "/way/{id}", method = RequestMethod.GET)
    public @ResponseBody String wayId(@PathVariable int id) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("success",true);

        System.out.println(id);

        return response.toString();
    }

    @RequestMapping(value = "/way/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteWayId(@PathVariable int id) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("success",true);

        System.out.println(id);

        return response.toString();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public @ResponseBody String viewOrders() throws JSONException {
        JSONObject response = new JSONObject();
        response.put("success",true);


        return response.toString();
    }

    @RequestMapping(value = "/order/{id}/{status}", method = RequestMethod.GET)
    public @ResponseBody String order(@PathVariable int id,@PathVariable String status) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("success",true);

        System.out.println(id+" "+status);

        return response.toString();
    }
}
