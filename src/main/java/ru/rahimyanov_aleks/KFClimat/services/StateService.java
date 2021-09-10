package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rahimyanov_aleks.KFClimat.domain.State;
import ru.rahimyanov_aleks.KFClimat.domain.Type;
import ru.rahimyanov_aleks.KFClimat.repositories.StateRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IStateService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StateService implements IStateService {

    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    @Transactional
    public State createState(State state) {
        stateRepository.save(state);
        return state;
    }

    @Override
    @Transactional
    public String deleteState(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        if (optionalState.isPresent()){
            stateRepository.delete(optionalState.get());
            return "State with id:" + id + " was successfully remover";
        }
        return "unable to delete state";
    }

    @Override
    @Transactional
    public State getState(Long id) {
        Optional<State> stateOptional = stateRepository.findById(id);
        if (stateOptional.isPresent()){
            return stateOptional.get();
        }
        return null;
    }

    @Override
    public State getStateSearch() {
        Optional<State> stateOptional = stateRepository.findById(1L);
        if (stateOptional.isPresent()){
            return stateOptional.get();
        }
        return null;
    }

    @Override
    public State getStatePerformance() {
        Optional<State> stateOptional = stateRepository.findById(2L);
        if (stateOptional.isPresent()){
            return stateOptional.get();
        }
        return null;
    }

    @Override
    public State getStateCompleted() {
        Optional<State> stateOptional = stateRepository.findById(3L);
        if (stateOptional.isPresent()){
            return stateOptional.get();
        }
        return null;
    }

    @Override
    public State getStateCanceled() {
        Optional<State> stateOptional = stateRepository.findById(4L);
        if (stateOptional.isPresent()){
            return stateOptional.get();
        }
        return null;
    }

    @Override
    @Transactional
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}
