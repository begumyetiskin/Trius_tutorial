package trius.springframework.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trius.springframework.commands.UserForm;
import trius.springframework.converters.UserFormToUser;
import trius.springframework.domain.User;
import trius.springframework.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private UserFormToUser userFormToUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserFormToUser userFormToUser) {
        this.userRepository = userRepository;
        this.userFormToUser = userFormToUser;
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }


    @Override
    public User saveUserForm(UserForm userForm) {
        User savedUser = save(userFormToUser.convert(userForm));
        System.out.println("Saved User Email: " + savedUser.getEmail());
        return savedUser;
    }
}
