package com.letscode.userapi.controller;

import com.letscode.userapi.domain.UserEntity;
import com.letscode.userapi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity user = this.userRepository.save(userEntity);

        return ResponseEntity.created(URI.create(String.format("/user/%s", user.getId()))).body(user);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable String id) {
        Optional<UserEntity> user = this.userRepository.findById(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.get());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable String id) {
        Optional<UserEntity> user = this.userRepository.findById(id);

         if (user.isEmpty()) {
             return ResponseEntity.notFound().build();
         }

         this.userRepository.deleteById(id);

//         return ResponseEntity.ok(this.userRepository.findById(id).get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/alter/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable String id, @RequestBody UserEntity userDetails) {
        Optional<UserEntity> user = this.userRepository.findById(id);

        if(user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        user.get().setName(userDetails.getName());
        user.get().setBalance(userDetails.getBalance());
        this.userRepository.save(user.get());

        return ResponseEntity.ok(user.get());
    }



}
