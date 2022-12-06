package com.example.omdbapirest.user;

import com.example.omdbapirest.movie.Movie;
import com.example.omdbapirest.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
     private final MovieService  movieService;
    private final UserRepository repository;
    private final UserService service;


    @GetMapping("/favouritemovies/{id}")
    public List<Movie> getUsersFavoriteMovies(@PathVariable(name="id") int userId){
        AppUser user = repository.getReferenceById(userId);
        return user.getFavouriteMovies();
    }

    @PostMapping("/{id}/{moviename}")
    public void addMovieAsFavorite (@PathVariable (name= "id") int userId,
                                    @PathVariable (name="moviename") String movieName){
        service.addMovieAsFavorite(userId,movieName);
    }
}
