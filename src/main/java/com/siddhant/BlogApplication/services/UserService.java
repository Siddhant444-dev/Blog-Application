package com.siddhant.BlogApplication.services;

import com.siddhant.BlogApplication.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

}
