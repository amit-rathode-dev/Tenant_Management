package com.example.tenantmgmt.controller;

import com.example.tenantmgmt.entity.Owner;
import com.example.tenantmgmt.service.OwnerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private final OwnerServiceImpl ownerServiceImpl;

    public OwnerController(OwnerServiceImpl ownerServiceImpl){
        this.ownerServiceImpl = ownerServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerServiceImpl.getAllOwners();
        return ResponseEntity.ok(owners);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
      Owner owner = ownerServiceImpl.getOwnerById(id);
      return ResponseEntity.status(HttpStatus.OK).body(owner);
    }

    @PostMapping("/addOwner")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
        Owner savedOwner = ownerServiceImpl.addOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOwner);
    }
}
