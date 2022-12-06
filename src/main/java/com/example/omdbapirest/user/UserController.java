package com.example.omdbapirest.user;

import com.example.omdbapirest.movie.Movie;
import com.example.omdbapirest.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
     private final MovieService  movieService;
    private final UserRepository repository;
    private final UserService service;


    @GetMapping("/favouritemovies/{id}")
    public List<Movie> getUsersFavoriteMovies(@PathVariable(name="id") int id){
        wUser user = repository.getReferenceById(id);
        return user.getFavouriteMovies();
    }

    @PostMapping("/{id}/{moviename}")
    public void addMovieAsFavorite (@PathVariable (name= "id") int id,
                                    @PathVariable (name="moviename") String moviename){
        String url = moviename;
        wUser user = repository.getReferenceById(id);
        List<Movie> movies = user.getFavouriteMovies();
        List<Movie>moviesToAdd = new ArrayList<>();
        Movie movie = movieService.getDataFromOMDBAsMovie(url);
        movies.add(movie);
        moviesToAdd.addAll(movies);
        user.setFavouriteMovies(moviesToAdd);
        repository.save(user);
    }
}
