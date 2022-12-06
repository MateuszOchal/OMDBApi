package com.example.omdbapirest.user;

import com.example.omdbapirest.movie.Movie;
import com.example.omdbapirest.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final MovieService movieService;
    public void addMovieAsFavorite (int id, String movieName){
        String url = movieName;
        AppUser user = repository.getReferenceById(id);
        List<Movie> movies = user.getFavouriteMovies();
        List<Movie>moviesToAdd = new ArrayList<>();
        Movie movie = movieService.getDataFromOMDBAsMovie(url);
        movies.add(movie);
        moviesToAdd.addAll(movies);
        user.setFavouriteMovies(moviesToAdd);
        repository.save(user);
    }
}
