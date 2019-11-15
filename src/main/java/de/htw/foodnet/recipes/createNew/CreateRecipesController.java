package de.htw.foodnet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class createRecipesController {
    @RequestMapping(value="createRecipes")
    public ModelAndView createRecipes() {
        return new ModelAndView("createRecipes");
    }

}
