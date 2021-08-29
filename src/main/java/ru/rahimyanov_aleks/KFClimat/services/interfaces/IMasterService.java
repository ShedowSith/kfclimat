package ru.rahimyanov_aleks.KFClimat.services.interfaces;


import ru.rahimyanov_aleks.KFClimat.domain.Master;

import java.util.List;

public interface IMasterService {
    Master findMasterByEmailAndPassword(String email, String password);
    Master createMaster(Master master);
    String deleteMaster(Long id);
    Master getMaster(Long id);
    Master updateMaster(Master master, Long id);
    List<Master> getAllMasters();
}
