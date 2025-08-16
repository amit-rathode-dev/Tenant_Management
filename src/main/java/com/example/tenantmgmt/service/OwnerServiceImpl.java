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

    public Owner getOwnerById(Long id){
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        return optionalOwner.get();
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner addOwner(Owner owner){
        return ownerRepository.save(owner);
    }

}
