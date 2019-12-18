package pl.miroslawbrz.czarteruj.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtilities {

    public static String getLoggedUser(){
        String userEmail = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            userEmail = authentication.getName();
        }
        return userEmail;
    }

}
