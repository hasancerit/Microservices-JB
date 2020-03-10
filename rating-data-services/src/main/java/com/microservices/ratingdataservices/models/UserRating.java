package com.microservices.ratingdataservices.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> ratings = new ArrayList<>();

    public UserRating() {
    }

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserRating(String userId, List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void initData(String userId){
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("500",4),
                new Rating("501",3)
        ));
    }
}
