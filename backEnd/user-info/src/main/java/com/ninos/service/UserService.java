package com.ninos.service;

import com.ninos.dto.UserDTO;

public interface UserService {

    UserDTO addUserInDB(UserDTO userDTO);
    UserDTO findByUserId(Long id);

}
