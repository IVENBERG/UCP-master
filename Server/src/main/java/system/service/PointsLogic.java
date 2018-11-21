package ucp.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import ucp.model.Points;
import ucp.service.PointsServiceImpl;

import java.io.IOException;
import java.util.List;

public class PointsLogic {
    public boolean addPoint(HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PointsServiceImpl pointsService = new PointsServiceImpl();
        Points points = new Points();
        JsonNode actualObj = mapper.readTree(request.getBody());

        String country = actualObj.get("country").textValue();
        String region = actualObj.get("region").textValue();
        String city = actualObj.get("city").textValue();
        List<Points> pointsList = pointsService.getPoints();

        if(region.equals("")) {
            String name = country+" "+city;
            points.setName(name);
            for(Points point : pointsList)
            {
                if(point.getName().equals(points.getName())) {
                    return false;
                }
            }
            pointsService.add(points);
            return true;
        }
        else{
            String name = country+" "+region+" "+city;
            points.setName(name);
            for(Points point : pointsList)
            {
                if(point.getName().equals(points.getName())) {
                    return false;
                }
            }
            pointsService.add(points);
            return true;
        }
    }
}
