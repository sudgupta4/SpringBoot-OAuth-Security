package com.sudhir.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

@RestController
public class OAuthController {
	
	@GetMapping("/")
    public String welcome(Principal principal) {
        Map<String, Object> oauthDetail = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();

        String name = (String) oauthDetail.get("name");

        return "Currently " + name + " Logged In!";
    }


}
