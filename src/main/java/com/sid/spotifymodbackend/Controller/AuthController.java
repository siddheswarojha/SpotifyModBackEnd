package com.sid.spotifymodbackend.Controller;


import com.sid.spotifymodbackend.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("spotifymod/api/v1/")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("login/")
    public String loginUser(@RequestParam Map<String,String> login)
    {
        return authService.loginUser(login);
    }


    @PostMapping("register/")
    public String register(@RequestParam Map<String,String> user)
    {
        return authService.register(user);
    }




}
