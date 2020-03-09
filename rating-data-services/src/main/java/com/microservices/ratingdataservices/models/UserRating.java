package com.microservices.ratingdataservices.models;

import java.util.ArrayList;
import java.util.List;

public class UserRating {
    private List<Rating> ratings = new ArrayList<>();

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
