package trius.springframework.converters;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import trius.springframework.commands.UserForm;
import trius.springframework.domain.User;

@Component
public class UserFormToUser implements Converter<UserForm, User>{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User convert(UserForm userForm){
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        return user;
    }
}

