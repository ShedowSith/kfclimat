package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByNameAndPassword(String name, String password);
    List<User> findAll();
}
