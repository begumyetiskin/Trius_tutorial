package trius.springframework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import trius.springframework.security.ApplicationUserDetailsService;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @GetMapping("/sign")
    public String sign(){
        return  "sign";
    }


}
