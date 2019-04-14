package it.controller;

import it.form.LoginForm;
import it.form.RegDriverForm;
import it.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Lazy
@Controller
public class AuthController {

    @Autowired
    @Lazy
    private DriverService driverService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String log(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLog(HttpServletResponse response, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        LoginForm form = LoginForm.builder()
                .email(email)
                .password(password)
                .build();
        String cookieValue = driverService.login(form);
        if (cookieValue != null) {
            Cookie auth = new Cookie("auth", cookieValue);
            response.addCookie(auth);
            return "profile";
        }
        return "login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String regDr(Model model) {
        return "reg";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String getRegForm(Model model, @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName,
                             @RequestParam(name = "email") String email, @RequestParam(name = "phone") String phone, @RequestParam(name = "password") String password,
                             @RequestParam(name = "haveCar") String haveCar) {
        RegDriverForm regDriverForm = RegDriverForm.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .haveCar(haveCar)
                .phoneNumber(phone)
                .password(password)
                .build();
        if (driverService.checkReg(regDriverForm.getEmail())) {
            return "login";
        }
        model.addAttribute("msg", "azaza, такой email уже юзается");
        return "reg";
    }
}
