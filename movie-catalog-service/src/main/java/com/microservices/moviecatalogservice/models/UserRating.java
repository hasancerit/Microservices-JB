package com.microservices.moviecatalogservice.models;

import java.util.ArrayList;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> ratings = new ArrayList<>();

    public UserRating() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
