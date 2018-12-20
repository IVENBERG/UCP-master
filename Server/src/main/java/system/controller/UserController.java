package system.controller;

import org.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import system.service.UsersLogic;

import java.io.IOException;

@Controller
public class UserController {
    //success
    @RequestMapping(value = "/activeUsers", method = RequestMethod.GET)
    public @ResponseBody String getAllActiveUsers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllActiveUsers();
    }
    //success
    @RequestMapping(value = "/allSeniorManager", method = RequestMethod.GET)
    public @ResponseBody String getAllSeniorManager() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllSeniorManager();
    }
    //success
    @RequestMapping(value = "/blockUsers", method = RequestMethod.GET)
    public @ResponseBody String getAllBlockUsers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllBlockUsers();
    }
    //success
    @RequestMapping(value = "/userInf/{user}", method = RequestMethod.GET)
    public @ResponseBody String getUser(@PathVariable String user) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUser(user);
    }
    //success
    @RequestMapping(value = "/allActiveManagers", method = RequestMethod.GET)
    public @ResponseBody String getAllActiveManagers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllActiveManagers();
    }
    //success
    @RequestMapping(value = "/allBlockManagers", method = RequestMethod.GET)
    public @ResponseBody String getAllBlockManagers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllBlockManagers();
    }
    //success
    @RequestMapping(value = "/allStatusBlockManagers", method = RequestMethod.GET)
    public @ResponseBody String getAllStatusBlockManagers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllStatusBlockManagers();
    }
    //success
    @RequestMapping(value = "/blockManager/{login}", method = RequestMethod.GET)
    public @ResponseBody String blockManager(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnBlockManager(login);
    }
    //success
    @RequestMapping(value = "/unblockManager/{login}", method = RequestMethod.GET)
    public @ResponseBody String unblockManager(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUnblockManager(login);
    }
    //success
    @RequestMapping(value = "/upManager/{login}", method = RequestMethod.GET)
    public @ResponseBody String upManager(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUpManager(login);
    }
    //success
    @RequestMapping(value = "/blockUser/{login}", method = RequestMethod.GET)
    public @ResponseBody String blockUser(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnBlockManager(login);
    }
    //success
    @RequestMapping(value = "/unblockUser/{login}", method = RequestMethod.GET)
    public @ResponseBody String unblockUser(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUnblockManager(login);
    }
    //success
    @RequestMapping(value = "/userOrders/{login}", method = RequestMethod.GET)
    public @ResponseBody String userOrders(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUserOrders(login);
    }
    //success
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody String serchWays(HttpEntity<String> request) throws JSONException, IOException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnSearch(request);
    }
    //success
    @RequestMapping(value = "/changePas/{login}", method = RequestMethod.POST)
    public @ResponseBody String changePas(HttpEntity<String> request, @PathVariable String login) throws JSONException, IOException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnChangePass(login, request);
    }

    @RequestMapping(value = "/edit/{login}", method = RequestMethod.POST)
    public @ResponseBody String changeInfo(HttpEntity<String> request, @PathVariable String login) throws JSONException, IOException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnChange(login, request);
    }

}
