package com.newproject.basicprojectskeleton.persistence.repository;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByName(String name);
}
