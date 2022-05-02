package com.sid.spotifymodbackend.Services;

import com.sid.spotifymodbackend.Model.User;
import com.sid.spotifymodbackend.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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


    public String register(Map<String, String> user) {
        Optional<User> userOptional = authRepo.findUserByEmailAddress(user.get("emailAddress"));

        if(userOptional.isPresent())
        {
            return "Email Address already in use";

        }

        else if(user.get("emailAddress")==null || user.get("name")==null|| user.get("password")==null)
        {
            return "Bad Body Found";
        }
        else
        {

            String key = UUID.randomUUID().toString();

            User userObj = new User();

            userObj.setApiKey(key);
            userObj.setEmailAddress(user.get("emailAddress"));
            userObj.setName(user.get("name"));
            userObj.setPassword(user.get("password"));
            authRepo.save(userObj);
            return "Registered";
        }

    }
}
