package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.rahimyanov_aleks.KFClimat.domain.Master;

import java.util.List;
import java.util.Optional;

public interface MasterRepository extends CrudRepository<Master, Long> {
    List<Master> findAllBy();
    Optional<Master> findMasterByEmailAndPassword(String email, String password);
}
