package com.microservices.ratingdataservices.resources;

import com.microservices.ratingdataservices.models.Rating;
import com.microservices.ratingdataservices.models.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratingsdata")
public class RatingResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @GetMapping("user/{userId}")
    public UserRating getRatingsByUserId(@PathVariable("userId") String userId){
        UserRating us = new UserRating();
        us.initData(userId);
        return us;
    }


}
