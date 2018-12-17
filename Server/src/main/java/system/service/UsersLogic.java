package system.service;

import org.json.JSONObject;
import system.dao.UserDAOImpl;
import system.entity.User;

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
}
