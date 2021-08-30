package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Type;

import java.util.List;

public interface ITypeService {
    Type createType(Type type);
    String deleteType(Long id);
    Type getType(Long id);
    List<Type> getAllTypes();
}
