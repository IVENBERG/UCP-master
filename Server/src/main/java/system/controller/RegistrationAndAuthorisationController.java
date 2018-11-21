package system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.anotherClass.AnotherClass;
import system.entity.UsersEntity;
import system.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationAndAuthorisationController {

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addNewUser(@ModelAttribute("registrationInformarion") UsersEntity usersEntity) {
        AnotherClass rc = new AnotherClass();
        UsersService usersService = new UsersService();
        List<UsersEntity> ue = usersService.getUser(usersEntity);
        for(int i=0; i < ue.size();i++)
        {
            if(ue.get(i).getEmail().equals(usersEntity.getEmail())){
                rc.setReturnString("error");
                List<AnotherClass> retc = new ArrayList<AnotherClass>();
                retc.add(rc);
                return new ModelAndView("index","registrationObject",retc);
            }
        }
        usersService.add(usersEntity);
        rc.setReturnString("confirm");
        List<AnotherClass> retc = new ArrayList<AnotherClass>();
        retc.add(rc);
        return new ModelAndView("index","registrationObject",retc);
    }


    @RequestMapping(value = "authorisation", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView authorisation(@ModelAttribute("authorisationInformation") UsersEntity usersEntity) {
        AnotherClass rc = new AnotherClass();
        UsersService usersService = new UsersService();
        List<UsersEntity> ue = usersService.getUser(usersEntity);
        for(int i=0; i<ue.size();i++)
        {
            if(ue.get(i).getEmail().equals(usersEntity.getEmail()) && ue.get(i).getPassword().equals(usersEntity.getPassword())){
                rc.setReturnString("User");
                AnotherClass.id_user = ue.get(i).getId();
                List<AnotherClass> retc = new ArrayList<AnotherClass>();
                retc.add(rc);
                return new ModelAndView("index","authorisationObject",retc);
            }
        }
        rc.setReturnString("error");
        List<AnotherClass> retc = new ArrayList<AnotherClass>();
        retc.add(rc);
        return new ModelAndView("index","authorisationObject",retc);
    }


    @RequestMapping(value = "exit", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView exit() {
        AnotherClass.id_user = 0;
        AnotherClass rc = new AnotherClass();
        rc.setReturnString("error");
        List<AnotherClass> retc = new ArrayList<AnotherClass>();
        retc.add(rc);
        return new ModelAndView("index","authorisationObject",retc);
    }
}
