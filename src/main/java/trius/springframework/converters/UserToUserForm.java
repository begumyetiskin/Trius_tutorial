package trius.springframework.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import trius.springframework.commands.UserForm;
import trius.springframework.domain.User;

@Component
public class UserToUserForm implements Converter<User, UserForm> {
    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setEmail(user.getEmail());
        userForm.setPassword(user.getPassword());
        return userForm;
    }
}