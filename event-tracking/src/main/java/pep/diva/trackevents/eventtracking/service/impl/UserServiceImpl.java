package pep.diva.trackevents.eventtracking.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pep.diva.trackevents.eventtracking.model.User;
import pep.diva.trackevents.eventtracking.repository.RoleRepository;
import pep.diva.trackevents.eventtracking.repository.UserRepository;
import pep.diva.trackevents.eventtracking.service.UserService;

/**
 * @author divakar
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
