package com.example.omdbapirest.user;

import com.example.omdbapirest.movie.Movie;
import com.example.omdbapirest.movie.MovieService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMockData {

     private final UserRepository repository;
     private final MovieService service;

    @PostConstruct
    public void UserMock(){
        wUser user = new wUser("Jack", List.of(service.getDataFromOMDBAsMovie("mulan"),
                                                     service.getDataFromOMDBAsMovie("anastasia")));

        wUser user1 = new wUser("Jacob", List.of(service.getDataFromOMDBAsMovie("fight+club"),
                                                       service.getDataFromOMDBAsMovie("silence+of+the+lambs&y=1991")));

        wUser user2 = new wUser("Kate", List.of(service.getDataFromOMDBAsMovie("love+actually"),
                                                      service.getDataFromOMDBAsMovie("titanic")));

        repository.save(user);
        repository.save(user1);
        repository.save(user2);
    }
}
