package com.example.omdbapirest.user;


import com.example.omdbapirest.movie.MovieService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMockData {

     private final UserRepository repository;
     private final MovieService service;

    @PostConstruct
    public void UserMock(){
        AppUser user = new AppUser("Jack", List.of(service.getDataFromOMDBAsMovie("mulan"),
                                                     service.getDataFromOMDBAsMovie("anastasia")));

        AppUser user1 = new AppUser("Jacob", List.of(service.getDataFromOMDBAsMovie("fight+club"),
                                                       service.getDataFromOMDBAsMovie("silence+of+the+lambs&y=1991")));

        AppUser user2 = new AppUser("Kate", List.of(service.getDataFromOMDBAsMovie("love+actually"),
                                                      service.getDataFromOMDBAsMovie("titanic")));

        repository.save(user);
        repository.save(user1);
        repository.save(user2);
    }
}
