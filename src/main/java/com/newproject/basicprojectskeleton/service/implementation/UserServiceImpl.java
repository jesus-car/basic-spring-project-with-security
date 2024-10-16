package com.newproject.basicprojectskeleton.service.implementation;

import com.newproject.basicprojectskeleton.persistence.entity.Role;
import com.newproject.basicprojectskeleton.persistence.entity.UserEntity;
import com.newproject.basicprojectskeleton.persistence.repository.RoleRepository;
import com.newproject.basicprojectskeleton.persistence.repository.UserRepository;
import com.newproject.basicprojectskeleton.presentation.dto.input.UserSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.UserSaveResponse;
import com.newproject.basicprojectskeleton.util.RoleEnum;
import com.newproject.basicprojectskeleton.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponse saveUser(UserSaveRequest userSaveRequest) {
        UserEntity userEntity = userMapper.toUserEntity(userSaveRequest);

        Set<Role> roles = new HashSet<>();
        roleRepository.findByName(RoleEnum.ROLE_USER).ifPresent(roles::add);

        if(userEntity.isAdmin())
            roleRepository.findByName(RoleEnum.ROLE_ADMIN).ifPresent(roles::add);

        userEntity.setRoles(roles);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setCreatedAt(LocalDateTime.now());

        return userMapper.toUserSaveResponse(userRepository.save(userEntity));
    }

    @Transactional(readOnly = true)
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional(readOnly = true)
    public UserSaveResponse getUser(String username) {
        return userMapper.toUserSaveResponse(userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
