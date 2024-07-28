package com.API.investmentaggregator.Service;

import com.API.investmentaggregator.controller.CreateUserDto;
import com.API.investmentaggregator.repository.UserRepository;
import com.API.investmentaggregator.entity.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UUID createUser(CreateUserDto createUserDto) {
        // DTO => ENTITY
        var entity = new User(
          UUID.randomUUID(),
          createUserDto.username(),
          createUserDto.email(),
          createUserDto.password(),
          Instant.now(),
          null
        );

        var userSaved = this.userRepository.save(entity);

        return  userSaved.getUserId();
    }
}
