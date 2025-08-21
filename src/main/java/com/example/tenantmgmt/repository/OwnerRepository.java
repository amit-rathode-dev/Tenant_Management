package com.example.tenantmgmt.repository;

import com.example.tenantmgmt.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByIsDeletedFalse();
}
