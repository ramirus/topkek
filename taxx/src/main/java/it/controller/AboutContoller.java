package it.controller;

import it.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AboutContoller {

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String loadPage(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("driverEmail") != null) {
            model.addAttribute("loged", "loged");
        }
//        if(authentication.getPrincipal()!=null) {
//            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//            if (userDetails.getDriver() != null) {
//                model.addAttribute("loged", "loged");
//            }
//        }
        return "aboutUs";
    }
}
