package de.hsba.a16.bi.mitfahrtszentrale.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            createUser("admin", "admin", "ADMIN", "Admin", "Last Name Admin", "mo@mail.com");
            createUser("Anne", "123456", "USER", "first Anne", "last Anne", "mail@gmail.com");

        }
    }

    public void createUser(String username, String password, String role, String firstName, String lastName, String email) {
        userRepository.save(new User(username, passwordEncoder.encode(password), role, firstName, lastName, email));
    }
    public void createUserByEntiy (User user){
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	userRepository.save(user);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findUsers() {
        return userRepository.findUsers();
    }
}
