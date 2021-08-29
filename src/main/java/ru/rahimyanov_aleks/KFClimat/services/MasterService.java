package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.repositories.MasterRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IMasterService;


import java.util.List;
import java.util.Optional;

@Service
public class MasterService implements IMasterService {
    private final MasterRepository masterRepository;

    @Autowired
    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }


    @Override
    public Master findMasterByEmailAndPassword(String email, String password) {
        Optional<Master> masterOptional = masterRepository.findMasterByEmailAndPassword(email, password);
        if (masterOptional.isPresent()){
            return masterOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Master createMaster(Master master) {
        masterRepository.save(master);
        return master;
    }

    @Override
    public String deleteMaster(Long id) {
        Optional<Master> masterOptional = masterRepository.findById(id);
        if (masterOptional.isPresent()){
            masterRepository.delete(masterOptional.get());
            return "Master with id:" + id + " was successfully remover";
        } else {
            return "unable to delete master";
        }
    }

    @Override
    public Master getMaster(Long id) {
        Optional<Master> masterOptional = masterRepository.findById(id);
        return masterOptional.get();
    }

    @Override
    public Master updateMaster(Master master, Long id) {
        return null;
    }

    @Override
    public List<Master> getAllMasters() {
        return null;
    }
}
