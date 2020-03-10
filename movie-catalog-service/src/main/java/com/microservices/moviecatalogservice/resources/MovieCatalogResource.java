package com.microservices.moviecatalogservice.resources;

import com.microservices.moviecatalogservice.models.CatalogItem;
import com.microservices.moviecatalogservice.models.Movie;
import com.microservices.moviecatalogservice.models.Rating;
import com.microservices.moviecatalogservice.models.UserRating;
import com.microservices.moviecatalogservice.services.MovieInfo;
import com.microservices.moviecatalogservice.services.UserRatingInfo;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

      @Autowired
      MovieInfo movieInfo;

      @Autowired
      UserRatingInfo userRatingInfo;


    @GetMapping("/{userId}")
        public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        /*Before eureka
        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/"+userId,UserRating.class);*/

        System.out.println("1");
        UserRating ratings = userRatingInfo.getUserRating(userId);
        System.out.println("2");
        return ratings.getRatings().stream().map(rating ->{ return movieInfo.getCatalogItem(rating);})
        .collect(Collectors.toList());
    }
}
