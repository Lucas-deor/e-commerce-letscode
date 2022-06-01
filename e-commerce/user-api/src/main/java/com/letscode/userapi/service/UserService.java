package com.letscode.userapi.service;

import com.letscode.userapi.domain.UserEntity;
import com.letscode.userapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

//@Service
public class UserService {

//    private UserRepository userRepository;
//
//    public UserEntity createUser() {
//        return ResponseEntity.
//    }

}


//    @PostMapping(path = "/add")
//    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
//        UserEntity user = this.userRepository.save(userEntity);
//
//        return ResponseEntity.created(URI.create(String.format("/user/%s", user.getId()))).body(user);
//    }