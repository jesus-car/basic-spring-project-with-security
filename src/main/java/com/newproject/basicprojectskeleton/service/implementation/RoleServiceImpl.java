package com.newproject.basicprojectskeleton.service.implementation;

import com.newproject.basicprojectskeleton.persistence.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl {

    private final RoleRepository roleRepository;

    public void findByName(String name) {
        roleRepository.findByName(name);
    }


}