package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rahimyanov_aleks.KFClimat.domain.Power;
import ru.rahimyanov_aleks.KFClimat.repositories.PowerRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IPowerService;

import java.util.List;
import java.util.Optional;

@Service
public class PowerService implements IPowerService {
    private final PowerRepository powerRepository;

    @Autowired
    public PowerService(PowerRepository powerRepository) {
        this.powerRepository = powerRepository;
    }

    @Override
    @Transactional
    public Power createPower(Power power) {
        powerRepository.save(power);
        return power;
    }

    @Override
    @Transactional
    public String deletePower(Long id) {
        Optional<Power> optionalPower = powerRepository.findById(id);
        if (optionalPower.isPresent()){
            powerRepository.delete(optionalPower.get());
            return "Power with id:" + id + " was successfully remover";
        }
        return "unable to delete power";
    }

    @Override
    @Transactional
    public Power getPower(Long id) {
        Optional<Power> optionalPower = powerRepository.findById(id);
        return optionalPower.get();
    }

    @Override
    @Transactional
    public List<Power> getAllPowers() {
        return powerRepository.findAll();
    }
}
