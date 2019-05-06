package it.controller;

import it.model.RatingComment;
import it.security.UserDetailsImpl;
import it.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class RatingPageController {

    @Autowired
    @Lazy
    CommonService commonService;

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public String loadRPage(HttpServletRequest request, Model model) {
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        if (userDetails.getDriver() != null) {
//            model.addAttribute("loged", "loged");
//        }
        if (request.getSession().getAttribute("driverEmail") != null) {
            model.addAttribute("loged", "loged");
        }
        List<RatingComment> rc = commonService.getAllRatingCom();
        if (rc != null) {
            model.addAttribute("comments", rc);
        }
        return "rating";
    }

    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public String addNewRC(Model model, @RequestParam("phone") String clientPhone, @RequestParam("comment") String comment,
                           @RequestParam("ratingCount") Integer ratingCount) {
        RatingComment rc = RatingComment.builder()
                .clientPhone(clientPhone)
                .comment(comment)
                .ratingCount(ratingCount)
                .build();
        commonService.newRatingComment(rc);
        return "rating";
    }
}
