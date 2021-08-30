package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rahimyanov_aleks.KFClimat.domain.User;
import ru.rahimyanov_aleks.KFClimat.exceptions.CustomEmptyDataException;
import ru.rahimyanov_aleks.KFClimat.repositories.UserRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IUserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User findUserByNameAndPassword(String name, String password) {
        Optional<User> optionalUser = userRepository.findUserByNameAndPassword(name, password);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public String deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
            return "User with id:" + id + " was successfully remover";
        }
        return "unable to delete user";
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    @Transactional
    public User updateUser(User user, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User target = optionalUser.get();
            target.setPassword(user.getPassword());
            userRepository.save(target);
            return target;
        } else {
            throw new CustomEmptyDataException("unable to update user");
        }
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
