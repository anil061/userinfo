package com.learning.userInfo.service;

import com.learning.userInfo.dto.UserDTO;
import com.learning.userInfo.entity.User;
import com.learning.userInfo.mapper.UserMapper;
import com.learning.userInfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
       User savedUser =  userRepo.save(UserMapper.INSTANCE.mapUserDTOUser(userDTO));
       return UserMapper.INSTANCE.mapUserTOUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
      Optional<User> fetchUser = userRepo.findById(userId);
      if(fetchUser.isPresent())
          return new ResponseEntity<>(UserMapper.INSTANCE.mapUserTOUserDTO(fetchUser.get()), HttpStatus.OK);
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
