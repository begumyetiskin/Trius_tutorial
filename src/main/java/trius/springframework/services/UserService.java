package trius.springframework.services;



import trius.springframework.commands.UserForm;
import trius.springframework.domain.User;

public interface UserService {
    User save(User user);

    User saveUserForm(UserForm userForm);
}
