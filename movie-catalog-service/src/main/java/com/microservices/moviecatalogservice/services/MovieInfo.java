package com.microservices.moviecatalogservice.services;

import com.microservices.moviecatalogservice.models.CatalogItem;
import com.microservices.moviecatalogservice.models.Movie;
import com.microservices.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://InfoService/movies/"+rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(),movie.getOverview(),rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating){
        System.out.println("Info Service Yok/Yavas");
        return new CatalogItem("Info Service Yok/Yavas","",rating.getRating());
    }

}
