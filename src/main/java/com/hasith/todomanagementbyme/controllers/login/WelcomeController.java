package com.hasith.todomanagementbyme.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("name", "Hasith Malshan");
        return "welcome";
    }

}
