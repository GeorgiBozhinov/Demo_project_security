package com.example.Demo.data.repository;

import com.example.Demo.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAuthority(String auth);
}
