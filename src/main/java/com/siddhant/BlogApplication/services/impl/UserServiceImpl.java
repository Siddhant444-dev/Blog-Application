package com.siddhant.BlogApplication.services.impl;

import com.siddhant.BlogApplication.entities.User;
import com.siddhant.BlogApplication.repositories.UserRepository;
import com.siddhant.BlogApplication.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id '" + id + "' not found."));

    }
}
