package de.hsba.a16.bi.mitfahrtszentrale.user;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
@Transactional
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // save user
    public User createUser (User user){
        return userRepository.save(user);
    }
    @PostConstruct
    public void initUser (){
        if (showAllUser().isEmpty()){
            createUser(new User("somethig", "passs"));
            createUser(new User("somethig1", "passs"));
            createUser(new User("somethig2", "passs"));
            createUser(new User("somethig3", "passs"));

        }
    }
    // delete user
    public void deleteUser (Long id){
        this.userRepository.deleteById(id);
    }

    // edit user
    public void editUser (Long id){
        User user = userRepository.getOne(id);
        this.userRepository.save(user);
    }
    public Collection<User> showAllUser (){
        return userRepository.findAll();
    }

}
