package com.newproject.basicprojectskeleton.persistence.repository;

import com.newproject.basicprojectskeleton.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
