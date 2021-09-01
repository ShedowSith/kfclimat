package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.repositories.ApplicationRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IApplicationService;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService implements IApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    @Transactional
    public Application createApplication(Application application) {
        applicationRepository.save(application);
        return application;
    }

    @Override
    @Transactional
    public String deleteApplication(Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if (optionalApplication.isPresent()){
            applicationRepository.delete(optionalApplication.get());
            return "Application with id:" + id + " was successfully remover";
        }
        return "unable to delete application";
    }

    @Override
    @Transactional
    public Application getApplication(Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        return optionalApplication.get();
    }

    @Override
    @Transactional
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    @Transactional
    public List<Application> getAllApplicationForClient(Client client) {
        return applicationRepository.findAllByClient(client);
    }
}
