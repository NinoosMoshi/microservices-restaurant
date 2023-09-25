package com.ninos.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.ninos.dto.UserDTO;
import com.ninos.entity.User;
import com.ninos.mapper.UserMapper;
import com.ninos.repository.UserRepo;
import com.ninos.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    @Override
    public UserDTO addUserInDB(UserDTO userDTO) {
        User user = userMapper.fromUserDTOToUser(userDTO);
        User savedUser = userRepo.save(user);

        return userMapper.fromUserToDTO(savedUser);

    }

    @Override
    public UserDTO findByUserId(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
        return userMapper.fromUserToDTO(user);
    }
}
