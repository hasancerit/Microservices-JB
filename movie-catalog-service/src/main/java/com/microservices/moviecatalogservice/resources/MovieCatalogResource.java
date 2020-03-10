package com.microservices.moviecatalogservice.resources;

import com.microservices.moviecatalogservice.models.CatalogItem;
import com.microservices.moviecatalogservice.models.Movie;
import com.microservices.moviecatalogservice.models.Rating;
import com.microservices.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;
                /*Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        /*Before eureka
        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/"+userId,UserRating.class);*/
        UserRating ratings = restTemplate.getForObject("http://RatingService/ratingsdata/user/"+userId,UserRating.class);
        return ratings.getRatings().stream().map(rating ->{
            Movie movie = restTemplate.getForObject("http://InfoService/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(),"Test",rating.getRating());
        })
        .collect(Collectors.toList());
    }
}
