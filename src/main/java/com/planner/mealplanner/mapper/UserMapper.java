package com.planner.mealplanner.mapper;

import com.planner.mealplanner.dto.UserBaseDTO;
import com.planner.mealplanner.dto.UserDTO;
import com.planner.mealplanner.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDtoTOUser(UserDTO userDto);

    static User userBaseDTOToUser(UserBaseDTO userBaseDTO) {
        User user = new User();
        user.setName(userBaseDTO.getName());
        return user;
    }
}
