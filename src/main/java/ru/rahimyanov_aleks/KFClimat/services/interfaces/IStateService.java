package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.State;

import java.util.List;

public interface IStateService {
    State createState(State state);
    String deleteState(Long id);
    State getState(Long id);
    State getStateSearch();
    State getStatePerformance();
    State getStateCompleted();
    State getStateCanceled();
    List<State> getAllStates();
}
