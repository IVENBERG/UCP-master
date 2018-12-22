package system.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.servlet.ModelAndView;
import system.dao.OrderDAOImpl;
import system.dao.UserDAO;
import system.dao.UserDAOImpl;
import system.dao.WayInfoDAOImpl;
import system.entity.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        double v = Double.parseDouble(volume);
        return jsonGenerator.generateSearch(point1,point2,v);
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
    public String returnStaffAuth(HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        UserDAOImpl userDAO = new UserDAOImpl();
        JSONObject response = new JSONObject();

        String log = actualObj.get("log").textValue();
        int flag = actualObj.get("flag").intValue();
        String pas = actualObj.get("pas").textValue();

        User currentUser = userDAO.getUser(log);
        if(currentUser != null){
            if(currentUser.getPassword().equals(pas)){
                if(flag == 0){
                    response.put("success",true);
                   // response.put("role","user");
                    response.put("role",currentUser.getRole());
                    return response.toString();
                }
                else{
                    response.put("success",true);
                    response.put("role",currentUser.getRole());
                    return response.toString();
                }
            }
            else{
                response.put("success",false);
                response.put("message","Ошибка авторизации, неверный пароль ");
                return response.toString();
            }
        }
        else{
            response.put("success",false);
            response.put("message","Ошибка авторизации, сотрудник не найден");
            return response.toString();
        }
    }
    public String returnUserAuth(HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        UserDAOImpl userDAO = new UserDAOImpl();
        JSONObject response = new JSONObject();

        String login = actualObj.get("login").textValue();
        String pas = actualObj.get("pas").textValue();

        User currentUser = userDAO.getUser(login);
        if(currentUser != null) {

            if (currentUser.getPassword().equals(pas)) {
                response.put("success", true);
                return response.toString();
            } else {
                response.put("success", false);
                response.put("message", "Неверный логин или пароль");
                return response.toString();
            }
        }
        else{
            response.put("success", false);
            response.put("message", "Неверный логин или пароль");
            return response.toString();
        }

    }
    public String returnNewOrder(String login, int way_id, int volume) throws IOException {
        JSONObject object = new JSONObject();
        UserDAOImpl userDAO = new UserDAOImpl();
        WayInfoDAOImpl wayInfoDAO = new WayInfoDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        Orders order = new Orders();

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);

        User user = userDAO.getUser(login);
        WayInfo wayInfo = wayInfoDAO.getWay(way_id);
        double price = 0;

        for(Way w : wayInfo.getWays()){
            price = price + (w.getLine().getTransport().getKoeff()*w.getLine().getDistance()*volume);
        }

        order.setStatus("new");
        order.setVolume(volume);
        order.setUser(user);
        order.setWay(wayInfo);
        order.setPrice(price);
        order.setTime(strDate);

        orderDAO.add(order);


        object.put("success", true);

        return object.toString();
    }
    public String returnUserReg(HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        UserDAOImpl userDAO = new UserDAOImpl();
        JSONObject response = new JSONObject();

        String secondName = actualObj.get("secondName").textValue();
        String firstName = actualObj.get("firstName").textValue();
        String email = actualObj.get("email").textValue();
        String phone = actualObj.get("phone").textValue();
        String address = actualObj.get("address").textValue();
        String log = actualObj.get("log").textValue();
        String pasword = actualObj.get("pasword").textValue();

        User currentUser = userDAO.getUser(log);
        if(currentUser == null){
            User user = new User();
            user.setEmail(email);
            user.setPhone(phone);
            user.setAddress(address);
            user.setPassword(pasword);
            user.setLogin(log);
            user.setName(firstName);
            user.setRole("user");
            user.setStatus("active");
            user.setSurname(secondName);
            userDAO.add(user);

            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            response.put("message","Такой логин уже существует");
            return response.toString();
        }

    }
    public String returnManagerReg(HttpEntity<String> request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        UserDAOImpl userDAO = new UserDAOImpl();
        JSONObject response = new JSONObject();

        String firstName=actualObj.get("name").textValue();
        String log = actualObj.get("login").textValue();
        String pasword = actualObj.get("pas").textValue();
        String surname=actualObj.get("lastName").textValue();

        User currentUser = userDAO.getUser(log);
        if(currentUser == null){
            User user = new User();

            user.setPassword(pasword);
            user.setLogin(log);
            user.setName(firstName);
            user.setRole("manager");
            user.setStatus("active");
            user.setSurname(surname);
            userDAO.add(user);

            response.put("success",true);
            return response.toString();
        }
        else{
            response.put("success",false);
            response.put("message","Такой логин уже существует");
            return response.toString();
        }

    }
}
