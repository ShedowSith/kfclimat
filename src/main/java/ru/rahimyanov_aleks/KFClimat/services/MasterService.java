package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.exceptions.CustomEmptyDataException;
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
    @Transactional
    public Master findMasterByEmailAndPassword(String email, String password) {
        Optional<Master> masterOptional = masterRepository.findMasterByEmailAndPassword(email, password);
        if (masterOptional.isPresent()){
            return masterOptional.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Master createMaster(Master master) {
        masterRepository.save(master);
        return master;
    }

    @Override
    @Transactional
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
    @Transactional
    public Master getMaster(Long id) {
        Optional<Master> masterOptional = masterRepository.findById(id);
        return masterOptional.get();
    }

    @Override
    @Transactional
    public Master updateMaster(Master master, Long id) {
        Optional<Master> masterOptional = masterRepository.findById(id);
        if (masterOptional.isPresent()){
            Master target = masterOptional.get();
            target.setBrigade(master.getBrigade());
            target.setEmail(master.getEmail());
            target.setDescriptions(master.getDescriptions());
            target.setPassword(master.getPassword());
            target.setSurname(master.getSurname());
            target.setPatronymic(master.getPatronymic());
            target.setName(master.getName());
            masterRepository.save(target);
            return target;
        } else {
            throw new CustomEmptyDataException("unable to update master");
        }
    }

    @Override
    @Transactional
    public List<Master> getAllMasters() {
        return masterRepository.findAll();
    }
}
