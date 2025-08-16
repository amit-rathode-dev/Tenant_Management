package com.example.tenantmgmt.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@MappedSuperclass   // not an @Entity, but its fields are inherited
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp   // auto set when row is first created
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp     // auto update whenever row changes
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isDeleted;
}
