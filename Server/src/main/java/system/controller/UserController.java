package system.controller;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import system.service.UsersLogic;

@Controller
public class UserController {
    @RequestMapping(value = "/activeUsers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllActiveUsers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllActiveUsers();
    }

    @RequestMapping(value = "/allSeniorManager", method = RequestMethod.GET)
    public @ResponseBody
    String getAllSeniorManager() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllSeniorManager();
    }

    @RequestMapping(value = "/blockUsers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllBlockUsers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllBlockUsers();
    }

    @RequestMapping(value = "/userInf/{user}", method = RequestMethod.GET)
    public @ResponseBody String getUser(@PathVariable String user) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUser(user);
    }

    @RequestMapping(value = "/allActiveManagers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllActiveManagers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllActiveManagers();
    }

    @RequestMapping(value = "/allBlockManagers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllBlockManagers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllBlockManagers();
    }

    @RequestMapping(value = "/allStatusBlockManagers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllStatusBlockManagers() throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnAllStatusBlockManagers();
    }

    @RequestMapping(value = "/blockManager/{login}", method = RequestMethod.GET)
    public @ResponseBody String blockManager(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnBlockManager(login);
    }

    @RequestMapping(value = "/unblockManager/{login}", method = RequestMethod.GET)
    public @ResponseBody String unblockManager(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUnblockManager(login);
    }

    @RequestMapping(value = "/upManager/{login}", method = RequestMethod.GET)
    public @ResponseBody String upManager(@PathVariable String login) throws JSONException {
        UsersLogic usersLogic = new UsersLogic();
        return usersLogic.returnUpManager(login);
    }

}
