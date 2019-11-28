package de.htw.foodnet.pages;

import de.htw.foodnet.database.Entity.Role;
import de.htw.foodnet.database.Entity.User;
import de.htw.foodnet.database.RoleRepository;
import de.htw.foodnet.database.UserRepository;
import de.htw.foodnet.service.RegisterForm;
import de.htw.foodnet.service.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserValidator validator;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(Model model) {
        model.addAttribute("form",new RegisterForm());
        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public String postRecipe(@ModelAttribute RegisterForm form, BindingResult result) {
        validator.validate(form, result);
        if (result.hasErrors()) {
            System.out.println(result.getErrorCount());
            return "redirect:/register?error";
        }
        User user = new User();
        user.setEnabled(true);
        user.setName(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        List<Role> roles = new LinkedList<>();
        Role userRole = roleRepository.findByName("USER");
        roles.add(userRole);
        if(form.isChef()) {
            Role chefRole = roleRepository.findByName("CHEF");
            roles.add(chefRole);
        }
        user.setRoles(roles);

        userRepository.save(user);

        return "redirect:/login";
    }
}
