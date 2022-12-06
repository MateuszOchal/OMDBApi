package com.example.omdbapirest.movie;


import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService service;
    private final MovieRepository repository;

    @GetMapping
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @GetMapping("/{moviename}")
    public Movie movie(@PathVariable(name = "moviename") String moviename) throws ParseException {
        String link = "https://www.omdbapi.com/?t=" + moviename + "&apikey=30ccf40c";
        return service.getDataFromOMDBAsMovie(link);
    }
}





