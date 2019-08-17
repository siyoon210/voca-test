package kr.co.blossomedu.vocatest.users.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/new")
    public ModelAndView createForm() {
        return new ModelAndView("signup");
    }
}
