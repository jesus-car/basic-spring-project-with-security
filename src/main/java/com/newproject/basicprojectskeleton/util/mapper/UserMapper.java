package com.newproject.basicprojectskeleton.util.mapper;

import com.newproject.basicprojectskeleton.persistence.entity.UserEntity;
import com.newproject.basicprojectskeleton.presentation.dto.input.UserSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.UserSaveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserEntity toUserEntity(UserSaveRequest userSaveRequest);

    UserSaveResponse toUserSaveResponse(UserEntity userEntity);
}
