package com.microservices.moviecatalogservice.services;

import com.microservices.moviecatalogservice.models.Rating;
import com.microservices.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        System.out.println("ic1");
        UserRating userRating = restTemplate.getForObject("http://RatingService/ratingsdata/user/"+userId, UserRating.class);
        System.out.println("ic2");
        return userRating;
    }

    public UserRating getFallbackUserRating(String userId){
        System.out.println("Rating Service Yok/Yavas");
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Arrays.asList(
                new Rating("490",0)
        ));
        return userRating;
    }
}
