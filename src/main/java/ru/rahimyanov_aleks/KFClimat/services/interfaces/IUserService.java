package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.User;

import java.util.List;

public interface IUserService {
    User findUserByNameAndPassword(String name, String password);
    User createUser(User user);
    String deleteUser(Long id);
    User getUser(Long id);
    User updateUser(User user, Long id);
    List<User> getAllUsers();
}
