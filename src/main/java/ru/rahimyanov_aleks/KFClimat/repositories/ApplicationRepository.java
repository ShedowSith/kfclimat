package ru.rahimyanov_aleks.KFClimat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.domain.Master;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> findAll();
    List<Application> findAllByClient(Client client);

    @Query("select app from APPLICATIONS app, RESPONSES res where app.id = res.application.id and res.master = :find_master and app.id = :id")
    Optional<Application> findByAppForMasterAndAppId(@Param("find_master") Master master, @Param("id") Long id);

    @Query("select DISTINCT app from APPLICATIONS app left join RESPONSES res on app.id = res.application.id and res.master.id = :id where res.application.id is null")
    List<Application> findAllAppForNoResponseMaster_ID(@Param("id") Long id);
}
