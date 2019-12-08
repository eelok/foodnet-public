package de.htw.foodnet.register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {
    private RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("form",new RegisterForm());
        return "registerPage";
    }
    @PostMapping("/register")
    public String postRegister(@ModelAttribute RegisterForm form, BindingResult result) {
        boolean success = service.registerUser(form, result);
        if(!success) {
            return "redirect:/register?error";
        }
        return "redirect:/login";
    }
}
