package com.vam.timesheet.controller;



import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vam.timesheet.entity.EndUser;
import com.vam.timesheet.entity.Token;
import com.vam.timesheet.service.TokenService;

@RestController

public class TokenController {
	
    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
    	
        this.tokenService = tokenService;
        
    }
    

}