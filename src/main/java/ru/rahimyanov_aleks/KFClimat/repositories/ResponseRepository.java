package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.domain.Response;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
    List<Response> findAll();
    List<Response> findAllByMaster_Id(Long id);
    Optional<Response> findByApplication_IdAndSelected(Long id, boolean selected);
}
