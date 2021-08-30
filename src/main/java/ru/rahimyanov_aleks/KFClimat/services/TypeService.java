package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rahimyanov_aleks.KFClimat.domain.Type;
import ru.rahimyanov_aleks.KFClimat.repositories.TypeRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.ITypeService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    @Transactional
    public Type createType(Type type) {
        typeRepository.save(type);
        return type;
    }

    @Override
    @Transactional
    public String deleteType(Long id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        if (optionalType.isPresent()){
            typeRepository.delete(optionalType.get());
            return "Type with id:" + id + " was successfully remover";
        }
        return "unable to delete type";
    }

    @Override
    @Transactional
    public Type getType(Long id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        return optionalType.get();
    }

    @Override
    @Transactional
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}
