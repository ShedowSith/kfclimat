package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Master;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepository extends CrudRepository<Master, Long> {
    List<Master> findAll();
    Optional<Master> findMasterByEmailAndPassword(String email, String password);
}
