package com.example.tenantmgmt.service;

import com.example.tenantmgmt.entity.Owner;
import com.example.tenantmgmt.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl {

    OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + id));
    }


    public List<Owner> getAllOwners(){
//        return ownerRepository.findAll();
        return ownerRepository.findByIsDeletedFalse();
    }

    public Owner addOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner deleteOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found with id " + id));
        owner.setDeleted(true);
        return ownerRepository.save(owner);
    }



}
