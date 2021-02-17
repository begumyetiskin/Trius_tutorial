package trius.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import trius.springframework.commands.UserForm;
import trius.springframework.domain.User;
import trius.springframework.services.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/sign")
    public String newUser(Model model){
        model.addAttribute("userForm", new UserForm());
        return "/sign";
    }

    @RequestMapping( value = "/sign", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/sign";
        }

        User savedUser = userService.saveUserForm(userForm);
        return "redirect:/login/" + savedUser.getEmail();
    }

}
