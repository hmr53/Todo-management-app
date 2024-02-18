package com.hasith.todomanagementbyme.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "login" , method = RequestMethod.POST)
    public String authenticateUser(@RequestParam("username") String username , @RequestParam("password") String password, ModelMap modelMap){
        boolean authenticated = authenticationService.authenticate(username, password);

        if (authenticated){
            modelMap.put("iusername",username);
            return "list-todos";
        }else {
            modelMap.put("errorMsg", "Invalid Details Please check Username and password");
            return "login";
        }
    }

}
