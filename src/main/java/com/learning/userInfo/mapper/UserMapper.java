package com.learning.userInfo.mapper;

import com.learning.userInfo.dto.UserDTO;
import com.learning.userInfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOUser(UserDTO userdto);
    UserDTO mapUserTOUserDTO(User user);

}
