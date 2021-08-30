package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Type;

import java.util.List;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {
    List<Type> findAll();
}
