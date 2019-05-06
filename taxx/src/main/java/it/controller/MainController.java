package it.controller;

import it.form.OrderForm;
import it.model.Driver;
import it.security.UserDetailsImpl;
import it.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Lazy
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String loadMain(HttpServletRequest request, Model model, Authentication authentication) {
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        if (userDetails.getDriver() != null) {
//            model.addAttribute("loged", "loged");
//        }
        if (request.getSession().getAttribute("driverEmail") != null) {
            model.addAttribute("loged", "loged");
        }
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String getOrder(Model model, @RequestParam("phone") String phone, @RequestParam("comment") String commentForDriver,
                           @RequestParam("start") String startPoint, @RequestParam("end") String endPoint, @RequestParam("price") Integer price) {
        OrderForm orderForm = OrderForm.builder()
                .clientPhone(phone)
                .comment(commentForDriver)
                .firstAddress(startPoint)
                .lastAddress(endPoint)
                .price(price)
                .build();
        clientService.createNewOrder(orderForm);
        return "main";
    }

}
