package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.domain.State;

import java.util.List;

public interface IApplicationService {
    Application createApplication(Application application);
    String deleteApplication(Long id);
    Application getApplication(Long id);
    List<Application> getAllApplications();
    Application updateStateApplication(Long id, State state);
    List<Application> getAllApplicationForClient(Client client);
    Application getApplicationResponseMaster(Long id, Master master);
    List<Application> getAllAppNotResponseMaster(Long id);
}
