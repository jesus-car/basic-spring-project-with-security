package com.newproject.basicprojectskeleton.util.mapper;

import com.newproject.basicprojectskeleton.persistence.entity.UserEntity;
import com.newproject.basicprojectskeleton.presentation.dto.input.UserSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.UserSaveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "isEnabled", constant = "true")
    @Mapping(target = "isLocked", constant = "false")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    UserEntity toUserEntity(UserSaveRequest userSaveRequest);

    UserSaveResponse toUserSaveResponse(UserEntity userEntity);
}
