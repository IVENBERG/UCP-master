package spring.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.Services.ManagerService;
import spring.model.PointsModel;

import java.io.IOException;

@Controller
public class ManagerController {
    ManagerService managerService = new ManagerService();

    @RequestMapping(value = "/addpoin", method = RequestMethod.POST)
    public @ResponseBody String addPoint(HttpEntity<String> request) throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();
        PointsModel points = new PointsModel();
        JsonNode actualObj = mapper.readTree(request.getBody());

        points.setName(managerService.addPoint(actualObj));

        System.out.println(points.getName());

        JSONObject response = new JSONObject();
        response.put("success",true);

        return response.toString();
    }

    @RequestMapping(value = "/addway", method = RequestMethod.POST)
    public @ResponseBody String addWay(HttpEntity<String> request) throws IOException, JSONException {

        final JsonNode arrNode = new ObjectMapper().readTree(request.getBody()).get("data");
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {
                managerService.addWay(objNode);
                System.out.println(managerService.addWay(objNode));
            }
        }

        JSONObject response = new JSONObject();
        response.put("success",true);

        return response.toString();
    }

    @RequestMapping(value = "/allways", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String allWays() throws IOException, JSONException{
        JSONArray jsonArray = managerService.allWays();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",jsonArray);
        jsonObject.put("success",true);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }
}
