package com.example.Demo.service.services;

import com.example.Demo.data.model.User;
import com.example.Demo.data.repository.RoleRepository;
import com.example.Demo.data.repository.UserRepository;
import com.example.Demo.service.models.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User register(UserServiceModel model) {

        User user = this.modelMapper.map(model, User.class);

        if (this.userRepository.count() == 0){
            roleService.seedRolesInDb();

            user.setAuthorities(new HashSet<>(this.roleRepository.findAll()));
        }else{
            user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("USER"))));
        }

        return null;
    }
}
