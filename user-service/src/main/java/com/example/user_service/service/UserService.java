package com.example.user_service.service;
import com.example.user_service.entity.User;
import com.example.user_service.exception.UserNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService{

    public List<User> fetchUserList();

    public User save(User user);

    User findUserById(long id) throws UserNotFound, UserNotFound;

    public boolean deleteUserById(long id);

    public User updateUserById(long id,User user);
}
