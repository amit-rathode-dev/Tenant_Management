package com.example.tenantmgmt.entity;

import com.example.tenantmgmt.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyName;
    private String address;
    private String city;
    private String state;
    private String pincode;

    // Relationship with Owner
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;
}