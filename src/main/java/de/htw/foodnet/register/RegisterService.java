package de.htw.foodnet.register;

import de.htw.foodnet.login.Role;
import de.htw.foodnet.login.RoleRepository;
import de.htw.foodnet.login.User;
import de.htw.foodnet.login.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.LinkedList;
import java.util.List;

@Component
public class RegisterService {
    private UserRepository userRepository;
    private UserValidator validator;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository,
                           UserValidator validator,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerUser(RegisterForm form, BindingResult result) {
        validator.validate(form, result);
        if (result.hasErrors()) {
            System.out.println(result.getErrorCount());
            return false;
        }
        createUser(form);
        return true;
    }
    private void createUser(RegisterForm form) {
        User user = new User();
        user.setEnabled(true);
        user.setName(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        List<Role> roles = new LinkedList<>();
        createRoles();
        Role userRole = roleRepository.findByName("USER");
        roles.add(userRole);
        if(form.isChef()) {
            Role chefRole = roleRepository.findByName("CHEF");
            roles.add(chefRole);
        }
        user.setRoles(roles);
        userRepository.save(user);
    }
    private void createRoles() {
        createRoleIfNotExist("USER");
        createRoleIfNotExist("CHEF");
    }
    private void createRoleIfNotExist(String roleName) {
        Role userRole = roleRepository.findByName(roleName);
        if (userRole==null) {
            Role role = new Role(roleName);
            roleRepository.save(role);
        }
    }
}
