package com.sid.spotifymodbackend.Repository;


import com.sid.spotifymodbackend.Model.SongModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends MongoRepository<SongModel, ObjectId> {
}
