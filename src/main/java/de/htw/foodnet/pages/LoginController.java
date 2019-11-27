package de.htw.foodnet.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }
    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register");
    }
}
