package com.aleksandr.blogca2023.service;

import com.aleksandr.blogca2023.dto.UserDto;
import com.aleksandr.blogca2023.entities.User;


import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}