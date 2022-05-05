package com.sid.spotifymodbackend.Services;


import com.sid.spotifymodbackend.Model.SongModel;
import com.sid.spotifymodbackend.Model.User;
import com.sid.spotifymodbackend.Repository.AuthRepo;
import com.sid.spotifymodbackend.Repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class SongServices {

    @Autowired
    private SongRepo songRepo;

    @Autowired
    private AuthRepo authRepo;


    public List<SongModel> getAllSongs(String apiKey) {
        Optional<User> userOptional = authRepo.findUserByApiKey(apiKey);
        List<SongModel> songs = new ArrayList<>();
        if(userOptional.isPresent())
        {
            songs = songRepo.findAll();

        }
        return  songs;

    }

}
