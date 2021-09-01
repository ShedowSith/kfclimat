package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Client;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> findAll();
    List<Application> findAllByClient(Client client);
}
