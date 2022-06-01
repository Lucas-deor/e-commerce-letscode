package com.letscode.userapi.repository;

import com.letscode.userapi.domain.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
