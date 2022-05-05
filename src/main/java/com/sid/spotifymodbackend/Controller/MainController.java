package com.sid.spotifymodbackend.Controller;


import com.sid.spotifymodbackend.Model.SongModel;
import com.sid.spotifymodbackend.Model.User;
import com.sid.spotifymodbackend.Services.SongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spotifymod/api/v1/")
public class MainController {


    @Autowired
    private SongServices songServices;

    @GetMapping("/getallsongs")
    public List<SongModel> getAllSongs(@RequestParam String apiKey)
    {
        return songServices.getAllSongs(apiKey);

    }
}
