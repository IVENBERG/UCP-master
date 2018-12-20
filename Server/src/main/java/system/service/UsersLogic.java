package system.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import system.dao.OrderDAOImpl;
import system.dao.UserDAO;
import system.dao.UserDAOImpl;
import system.entity.Orders;
import system.entity.Points;
import system.entity.User;

import java.io.IOException;
import java.util.List;

public class UsersLogic {
    public String returnUpManager(String login){
        JSONObject response = new JSONObject();
        UserDAOImpl userDAO = new UserDAOImpl();

        if(userDAO.upManager(login) == true){
            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            return response.toString();
        }


    }
    public String returnBlockManager(String login){
        JSONObject response = new JSONObject();
        UserDAOImpl userDAO = new UserDAOImpl();

        if(userDAO.blockManager(login) == true){
            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            return response.toString();
        }


    }
    public String returnUnblockManager(String login){
        JSONObject response = new JSONObject();
        UserDAOImpl userDAO = new UserDAOImpl();

        if(userDAO.unblockManager(login) == true){
            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            return response.toString();
        }


    }
    public String returnBlockUser(String login){
        JSONObject response = new JSONObject();
        UserDAOImpl userDAO = new UserDAOImpl();

        if(userDAO.blockManager(login) == true){
            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            return response.toString();
        }


    }
    public String returnUnblockUser(String login){
        JSONObject response = new JSONObject();
        UserDAOImpl userDAO = new UserDAOImpl();

        if(userDAO.unblockManager(login) == true){
            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            return response.toString();
        }


    }
    public String returnAllActiveUsers(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList = userDAO.getActiveUsers();
        return jsonGenerator.generateAllUsers(userList);
    }
    public String returnAllSeniorManager(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList = userDAO.allSeniorManager();
        return jsonGenerator.generateAllUsers(userList);
    }
    public String returnAllBlockUsers(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList = userDAO.getBlockUsers();
        return jsonGenerator.generateAllUsers(userList);
    }
    public String returnUser(String login){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser(login);
        return jsonGenerator.generateUser(user);
    }
    public String returnAllActiveManagers(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList = userDAO.getActiveManagers();
        return jsonGenerator.generateAllUsers(userList);
    }
    public String returnAllBlockManagers(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList = userDAO.getBlockManagers();
        return jsonGenerator.generateAllUsers(userList);
    }
    public String returnAllStatusBlockManagers(){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> userList = userDAO.getStatusBlockManagers();
        return jsonGenerator.generateStatusBlockManagers(userList);
    }
    public String returnUserOrders(String login){
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        User user = userDAO.getUser(login);
        List<Orders> ordersList = orderDAO.getUserOrders(user.getIdUser());
        return jsonGenerator.generateUserOrders(ordersList);
    }
    public String returnSearch(HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        JsonGenerator jsonGenerator = new JsonGenerator();

        String point1 = actualObj.get("point1").textValue();
        String point2 = actualObj.get("point2").textValue();
        String volume = actualObj.get("volume").textValue();

        return jsonGenerator.generateSearch(point1,point2,volume);
    }
    public String returnChangePass(String login, HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        JsonGenerator jsonGenerator = new JsonGenerator();
        UserDAOImpl userDAO = new UserDAOImpl();
        JSONObject response = new JSONObject();

        String oldPas = actualObj.get("oldPas").textValue();
        String newPas = actualObj.get("newPas").textValue();
        String newPas2 = actualObj.get("newPas2").textValue();

        User currentUser = userDAO.getUser(login);
        if(currentUser.getPassword().equals(oldPas)){
            if(newPas.equals(newPas2)){
                userDAO.ubpatePass(newPas, currentUser.getLogin());
                response.put("success",true);
                return response.toString();
            }
            else{
                response.put("success",false);
                response.put("message","Пароли не совпадают");
                return response.toString();
            }
        }
        else {
            response.put("success",false);
            response.put("message","Вы ввели неверный пароль");
            return response.toString();
        }
    }
    public String returnChange(String login, HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        UserDAOImpl userDAO = new UserDAOImpl();
        JSONObject response = new JSONObject();

        String address = actualObj.get("address").textValue();
        String phone = actualObj.get("phone").textValue();
        String email = actualObj.get("email").textValue();

        User currentUser = userDAO.getUser(login);

        currentUser.setAddress(address);
        currentUser.setPhone(phone);
        currentUser.setEmail(email);

        userDAO.upateInfo(address,phone,email,currentUser.getLogin());

        response.put("success",true);
        return response.toString();
    }

}
