package system.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import system.dao.UserDAOImpl;
import system.service.UsersLogic;

import java.io.IOException;


@Controller
public class MoveController {

    @RequestMapping(value = "/staffAuthStandart", method = RequestMethod.POST)
    public @ResponseBody ModelAndView staffAuthStandart(HttpEntity<String> request) throws JSONException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(request.getBody());
        int flag = actualObj.get("flag").intValue();
        if(flag == 0 ){
            System.out.println("index");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        else if(flag == 1){
            System.out.println("admin");
            modelAndView.setViewName("admin");
            return modelAndView;
        }
        else{
            System.out.println("seniorManager");
            modelAndView.setViewName("seniorManager");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/userAuthStandart", method = RequestMethod.GET)
    public @ResponseBody ModelAndView userAuthStandart() throws JSONException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/userRegStandart", method = RequestMethod.GET)
    public @ResponseBody ModelAndView userRegStandart() throws JSONException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/adminExit", method = RequestMethod.GET)
    public @ResponseBody ModelAndView adminExit() throws JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInStaff");
        return modelAndView;
    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public @ResponseBody ModelAndView staff() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInStaff");
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody ModelAndView user() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInStaff");
        return modelAndView;
    }

    @RequestMapping(value = "/managerExit", method = RequestMethod.GET)
    public @ResponseBody ModelAndView managerExit() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInStaff");
        return modelAndView;
    }

    @RequestMapping(value = "/userExit", method = RequestMethod.GET)
    public @ResponseBody ModelAndView userExit() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInUser");
        return modelAndView;
    }

    @RequestMapping(value = "/logInStaff", method = RequestMethod.GET)
    public @ResponseBody ModelAndView logInStaff() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInStaff");
        return modelAndView;
    }

    @RequestMapping(value = "/logInUser", method = RequestMethod.GET)
    public @ResponseBody ModelAndView logInUser() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logInUser");
        return modelAndView;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public @ResponseBody ModelAndView index() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/seniorManager", method = RequestMethod.GET)
    public @ResponseBody ModelAndView seniorManager() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("seniorManager");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public @ResponseBody ModelAndView admin() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
