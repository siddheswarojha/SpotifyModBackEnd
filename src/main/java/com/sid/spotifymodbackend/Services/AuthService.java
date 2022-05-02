package com.sid.spotifymodbackend.Services;

import com.sid.spotifymodbackend.Model.User;
import com.sid.spotifymodbackend.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private AuthRepo authRepo;

    public String loginUser(Map<String, String> login) {

        User user = authRepo.findUserByEmailAddress(login.get("emailAddress"))
                .orElseThrow(() -> new IllegalStateException("User Not Found!"));


        if (login.get("password").equals(user.getPassword()))
        {
            return user.getApiKey();
        }
        else
        {
            return "Wrong Password";
        }
    }
}
