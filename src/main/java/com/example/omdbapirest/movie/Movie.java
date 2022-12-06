package com.example.omdbapirest.movie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movie_id")
    private Integer id;
    private String title;
    private String plot;
    private String genre;
    private String director;
    private String posterURL;

    public Movie(String title, String plot, String genre, String director, String posterURL) {
        this.title = title;
        this.plot = plot;
        this.genre = genre;
        this.director = director;
        this.posterURL = posterURL;
    }
}
