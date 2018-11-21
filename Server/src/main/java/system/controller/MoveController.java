package system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.anotherClass.AnotherClass;
import system.entity.*;
import system.service.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MoveController {
    AnotherClass rc = new AnotherClass();
    //Another
    @RequestMapping(value = "404", method = RequestMethod.GET)
    public String open404(Model model) {
        ServiceFormService serviceFormService = new ServiceFormService();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            return "404";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            return "404";
        }
    }
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String openForm(Model model) {
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            return "form";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            return "form";
        }
    }
    @RequestMapping(value = "formEdit", method = RequestMethod.GET)
    public String openFormEdit(Model model) {
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            return "formEdit";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            return "formEdit";
        }
    }
    @RequestMapping(value="about", method = RequestMethod.GET)
    public String openMasters(Model model) {
        MasterService masterService = new MasterService();
        List<MasterEntity> masterEntityList = masterService.getAll();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("masterEntityList",masterEntityList);
            return "about";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("masterEntityList",masterEntityList);
            return "about";
        }
    }
    //Service
    @RequestMapping(value = "nail", method = RequestMethod.GET)
    public String openNail(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> nailList = serviceService.getNail();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("nailList",nailList);
            return "nail";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("nailList",nailList);
            return "nail";
        }
    }
    @RequestMapping(value = "hair", method = RequestMethod.GET)
    public String openHair(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> hairList = serviceService.getHair();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("hairList",hairList);
            return "hair";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("hairList",hairList);
            return "hair";
        }
    }
    @RequestMapping(value = "spa", method = RequestMethod.GET)
    public String openSpa(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> spaList = serviceService.getSpa();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("spaList",spaList);
            return "spa";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("spaList",spaList);
            return "spa";
        }
    }
    @RequestMapping(value = "kosm", method = RequestMethod.GET)
    public String openKosm(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> kosmList = serviceService.getKosm();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("kosmList",kosmList);
            return "kosm";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("kosmList",kosmList);
            return "kosm";
        }
    }
    @RequestMapping(value = "depil", method = RequestMethod.GET)
    public String openDepil(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> depilList = serviceService.getDepil();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("depilList",depilList);
            return "depil";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("depilList",depilList);
            return "depil";
        }
    }
    @RequestMapping(value = "brow", method = RequestMethod.GET)
    public String openBrow(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> browList = serviceService.getBrow();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("browList",browList);
            return "brow";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("browList",browList);
            return "brow";
        }
    }
    @RequestMapping(value = "perm", method = RequestMethod.GET)
    public String openPerm(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> permList = serviceService.getPerm();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("permList",permList);
            return "perm";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("permList",permList);
            return "perm";
        }
    }
    @RequestMapping(value = "makeup", method = RequestMethod.GET)
    public String openMakeup(Model model) {
        ServiceService serviceService = new ServiceService();
        List<ServiceEntity> makeupList = serviceService.getMakeup();
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("makeupList",makeupList);
            return "makeup";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("makeupList",makeupList);
            return "makeup";
        }
    }
    //
    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String openContact(Model model) {
        AnotherClass rc = new AnotherClass();
        UsersService usersService = new UsersService();
        if(rc.getId_user()!=0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject",retc);
            return "contact";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject",retc);
            return "contact";
        }
    }
    //CategoryOfService
    @RequestMapping(value = "gallery", method = RequestMethod.GET)
    public String openGallery(Model model) {
        int ind = AnotherClass.id_user;
        CategoryOfServicesService categoryOfServicesService = new CategoryOfServicesService();
        List<CategoryOfServicesEntity> categoryList = categoryOfServicesService.getAll();
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("categoryList",categoryList);
            return "gallery";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            model.addAttribute("categoryList",categoryList);
            return "gallery";
        }
    }
    //
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String openIndex(Model model) {
        int ind = AnotherClass.id_user;
        if(ind != 0)
        {
            rc.setReturnString("User");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            ServiceFormService serviceFormService = new ServiceFormService();
            List<ServiceFormEntity> serviceFormEntities = serviceFormService.getAll();
            model.addAttribute("information",serviceFormEntities);
            model.addAttribute("authorisationObject", retc);
            return "index";
        }
        else {
            rc.setReturnString("error");
            List<AnotherClass> retc = new ArrayList<AnotherClass>();
            retc.add(rc);
            model.addAttribute("authorisationObject", retc);
            return "index";
        }
    }
}
