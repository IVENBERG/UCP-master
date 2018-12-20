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
public class MoveController {

    @RequestMapping(value = "/adminExit", method = RequestMethod.GET)
    public @ResponseBody String adminExit() throws IOException, JSONException {
        return "logInStaff";
    }
}
