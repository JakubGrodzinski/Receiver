package pl.coderslab.receiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.receiver.model.Role;
import pl.coderslab.receiver.model.User;
import pl.coderslab.receiver.repository.RoleRepository;
import pl.coderslab.receiver.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(){}

    @Override
    public User findByUserName(String name)
    {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
//        Role userRole = roleRepository.findByName("ROLE-USER");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
