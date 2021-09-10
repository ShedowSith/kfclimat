package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.domain.Response;

import java.util.List;

public interface IResponseService {
    Response createResponse(Response response);
    Response updateSelectedResponse(Long responseId);
    String deleteResponse(Long id);
    Response getResponse(Long id);
    List<Response> getAllResponses();
    List<Response> getAllResponsesMasterId(Long masterId);
}
