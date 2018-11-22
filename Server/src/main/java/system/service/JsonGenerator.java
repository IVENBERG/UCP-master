package system.service;

import org.json.JSONObject;

public class JsonGenerator {
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
}
