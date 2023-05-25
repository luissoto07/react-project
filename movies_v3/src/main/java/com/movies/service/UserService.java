package com.movies.service;

import com.movies.dto.LoginDTO;
import com.movies.dto.UserDTO;
import com.movies.response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);

}
