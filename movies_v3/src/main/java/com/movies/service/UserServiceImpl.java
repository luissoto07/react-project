package com.movies.service;

import com.movies.dto.LoginDTO;
import com.movies.dto.UserDTO;
import com.movies.entity.User;
import com.movies.reposority.UserRepo;
import com.movies.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {

        User user = new User(

                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );

        userRepo.save(user);

        return user.getName();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {

        String msg = "";
        User user1 = userRepo
                .findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("Password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }

}
