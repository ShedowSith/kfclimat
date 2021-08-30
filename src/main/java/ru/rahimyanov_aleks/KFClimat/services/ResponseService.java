package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rahimyanov_aleks.KFClimat.domain.Response;
import ru.rahimyanov_aleks.KFClimat.repositories.ResponseRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IResponseService;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService implements IResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    @Transactional
    public Response createUser(Response response) {
        responseRepository.save(response);
        return response;
    }

    @Override
    @Transactional
    public String deleteResponse(Long id) {
        Optional<Response> optionalResponse = responseRepository.findById(id);
        if (optionalResponse.isPresent()){
            responseRepository.delete(optionalResponse.get());
            return "Response with id:" + id + " was successfully remover";
        }
        return "unable to delete response";
    }

    @Override
    @Transactional
    public Response getResponse(Long id) {
        Optional<Response> optionalResponse = responseRepository.findById(id);
        return optionalResponse.get();
    }

    @Override
    @Transactional
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }
}
