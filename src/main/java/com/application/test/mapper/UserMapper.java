package com.application.test.mapper;

import com.application.test.dto.RegistrationUserDto;
import com.application.test.dto.UserDto;
import com.application.test.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegistrationUserDto RegistrationUserDtoFromUser(User user);

    UserDto UserDtoFromUser(User user);

    User toUser(RegistrationUserDto registrationUserDto);

    User toUser(UserDto userDto);
}
