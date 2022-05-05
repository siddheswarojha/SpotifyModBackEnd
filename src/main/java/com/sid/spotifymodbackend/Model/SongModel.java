package com.sid.spotifymodbackend.Model;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Document(collection = "song")
@Component

public class SongModel {
    @Id
    ObjectId _id;
    String songUrl;

    public SongModel(){}

    public SongModel(String songUrl)
    {
        this.songUrl=songUrl;
    }

}
