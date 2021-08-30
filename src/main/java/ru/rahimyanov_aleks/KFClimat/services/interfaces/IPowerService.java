package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Power;

import java.util.List;

public interface IPowerService {
    Power createPower(Power power);
    String deletePower(Long id);
    Power getPower(Long id);
    List<Power> getAllPowers();
}
