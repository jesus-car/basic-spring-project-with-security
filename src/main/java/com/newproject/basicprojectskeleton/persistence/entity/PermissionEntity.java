package com.newproject.basicprojectskeleton.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    // updatable = false means that the column cannot be updated in the database
    @Column(nullable = false, unique = true, updatable = false)
    private String name;
}
