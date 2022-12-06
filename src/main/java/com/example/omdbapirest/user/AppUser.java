package com.example.omdbapirest.user;

import com.example.omdbapirest.movie.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Movie> favouriteMovies;

    public AppUser(String name, List<Movie> favouriteMovies) {
        this.name = name;
        this.favouriteMovies = favouriteMovies;
    }
}
