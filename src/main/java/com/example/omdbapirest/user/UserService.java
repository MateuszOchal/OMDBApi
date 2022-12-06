package com.example.omdbapirest.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public wUser getUserById(int id){
        return repository.getReferenceById(id);
    }
    public wUser saveUser(wUser user){
        return repository.save(user);
    }
}
