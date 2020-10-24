package com.example.Demo.service.services;

import com.example.Demo.data.model.Role;
import com.example.Demo.data.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void seedRolesInDb() {
            this.roleRepository.saveAndFlush(new Role("ADMIN"));
            this.roleRepository.saveAndFlush(new Role("USER"));
    }
}
