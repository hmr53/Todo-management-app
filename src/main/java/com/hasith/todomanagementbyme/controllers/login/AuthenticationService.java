package com.hasith.todomanagementbyme.controllers.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username , String password){
        boolean isValidUsername = username.equalsIgnoreCase("hasith");
        boolean isValidPassword = password.equalsIgnoreCase("11223344");

        return isValidUsername && isValidPassword;
    }
}
