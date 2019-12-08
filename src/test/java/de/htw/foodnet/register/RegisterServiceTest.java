package de.htw.foodnet.register;

import de.htw.foodnet.login.Role;
import de.htw.foodnet.login.RoleRepository;
import de.htw.foodnet.login.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegisterServiceTest {
    private UserRepository userRepository;
    private UserValidator validator;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private RegisterService registerService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        validator = mock(UserValidator.class);
        roleRepository = mock(RoleRepository.class);
        passwordEncoder = new BCryptPasswordEncoder();
        registerService = new RegisterService(userRepository,validator,roleRepository,passwordEncoder);
    }

    @Test
    void registerUserCorrect() {
        when(userRepository.findByName("test")).thenReturn(null);
        when(roleRepository.findByName("USER")).thenReturn(new Role("USER"));
        BindingResult result = mock(BindingResult.class);
        RegisterForm form = mock(RegisterForm.class);
        when(form.getUsername()).thenReturn("test");
        when(form.getPassword()).thenReturn("test");
        when(form.isChef()).thenReturn(false);
        assertTrue(registerService.registerUser(form,result));
        verify(roleRepository, atLeastOnce()).findByName(any());
        verify(userRepository).save(any());
    }
}