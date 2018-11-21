package system.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
public class NewController {

    @RequestMapping(value = "/viewStudent", method = RequestMethod.POST)
    public @ResponseBody String viewStudent(HttpEntity<String> request) throws IOException, JSONException {

        final JsonNode arrNode = new ObjectMapper().readTree(request.getBody()).get("data");
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {

            }
        }

        JSONObject response = new JSONObject();
        response.put("success",true);

        return response.toString();
    }
}
