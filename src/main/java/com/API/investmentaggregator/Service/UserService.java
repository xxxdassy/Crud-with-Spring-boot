package com.API.investmentaggregator.Service;

import com.API.investmentaggregator.controller.CreateUserDto;
import com.API.investmentaggregator.repository.UserRepository;
import com.API.investmentaggregator.entity.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
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

    public Optional<User> getUserById(String userId) {
        return this.userRepository.findById(UUID.fromString(userId));
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUserById(String userId) {
        var id = UUID.fromString(userId);
        var userExists = this.userRepository.existsById(id);
        if(userExists) {
            this.userRepository.deleteById(id);
        }
    }
}
