package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.rahimyanov_aleks.KFClimat.domain.State;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Long> {
    List<State> findAll();
}
