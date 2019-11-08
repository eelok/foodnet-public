package de.htw.foodnet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AboutUsController {

    @RequestMapping(value = "/about")
    public ModelAndView getAboutUs() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
        String time = formatter.format(date);
        return new ModelAndView("about", "time", time);
    }
}
