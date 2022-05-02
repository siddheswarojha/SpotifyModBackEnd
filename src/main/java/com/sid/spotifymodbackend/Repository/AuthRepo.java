package com.sid.spotifymodbackend.Repository;


import com.sid.spotifymodbackend.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepo extends MongoRepository<User, ObjectId> {
    Optional<User> findUserByEmailAddress(String emailAddress);

    Optional<User> findUserByApiKey(String apiKey);
}
