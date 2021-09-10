package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
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
    public Response createResponse(Response response) {
        responseRepository.save(response);
        return response;
    }

    @Override
    public Response updateSelectedResponse(Long responseId) {
        Optional<Response> optionalResponse = responseRepository.findById(responseId);
        if (optionalResponse.isPresent()){
            Response response = optionalResponse.get();
            response.setSelected(true);
            responseRepository.save(response);
            return response;
        }
        return null;
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

    @Override
    public List<Response> getAllResponsesMasterId(Long masterId) {
        return responseRepository.findAllByMaster_Id(masterId);
    }

    public Response findSelectedResponseApplication(Long appId){
        Optional<Response> optionalResponse = responseRepository.findByApplication_IdAndSelected(appId, true);
        if (optionalResponse.isPresent()){
            return optionalResponse.get();
        } else {
            return null;
        }
    }
}
