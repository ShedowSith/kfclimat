package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Power;

import java.util.List;

@Repository
public interface PowerRepository extends CrudRepository<Power, Long> {
    List<Power> findAll();
}
