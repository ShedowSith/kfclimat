package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Response;

import java.util.List;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
    List<Response> findAll();
}
