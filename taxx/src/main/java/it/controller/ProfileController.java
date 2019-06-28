package it.controller;

import it.model.Driver;
import it.security.UserDetailsImpl;
import it.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ProfileController {
    @Lazy
    @Autowired
    DriverService driverService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String loadPage(Model model, Authentication authentication, HttpServletRequest request) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Driver driver = userDetails.getDriver();
        int sum = 120;
        model.addAttribute("sum", sum);
        model.addAttribute("driver", driver);
        return "profile";
    }
}
