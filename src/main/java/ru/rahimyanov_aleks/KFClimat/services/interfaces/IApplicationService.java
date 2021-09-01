package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Client;

import java.util.List;

public interface IApplicationService {
    Application createApplication(Application application);
    String deleteApplication(Long id);
    Application getApplication(Long id);
    List<Application> getAllApplications();
    List<Application> getAllApplicationForClient(Client client);
}
