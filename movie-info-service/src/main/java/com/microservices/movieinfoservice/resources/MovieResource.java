package com.microservices.movieinfoservice.resources;

import com.microservices.movieinfoservice.models.Movie;
import com.microservices.movieinfoservice.models.MovieSummary;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @Autowired
    RestTemplate restTemplate;
    @Value("${api.key}")
    String apiKey;

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        String url = "https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey;
        System.out.println("URL:"+url);
        MovieSummary ms = restTemplate.getForObject(url,MovieSummary.class);
        return new Movie(movieId,ms.getTitle(),ms.getOverview());
    }
}
