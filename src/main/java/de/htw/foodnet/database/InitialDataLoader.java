package de.htw.foodnet.database;

import de.htw.foodnet.database.Entity.Role;
import de.htw.foodnet.database.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }
        createRoleIfNotFound("CHEF");
        createRoleIfNotFound("USER");
        createStudent();
        createChef();
        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
    private void createStudent() {
        if (userRepository.findByName("student") != null) {
            return;
        }
        Role role = roleRepository.findByName("USER");
        User user = new User();
        user.setName("student");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRoles(Arrays.asList(role));
        user.setEnabled(true);
        userRepository.save(user);
    }
    private void createChef() {
        if (userRepository.findByName("chef") != null) {
            return;
        }
        Role userRole = roleRepository.findByName("USER");
        Role chefRole = roleRepository.findByName("CHEF");
        User user = new User();
        user.setName("chef");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRoles(Arrays.asList(chefRole));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
