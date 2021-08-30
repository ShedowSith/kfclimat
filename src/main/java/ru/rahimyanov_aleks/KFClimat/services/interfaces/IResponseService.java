package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Response;

import java.util.List;

public interface IResponseService {
    Response createUser(Response response);
    String deleteResponse(Long id);
    Response getResponse(Long id);
    List<Response> getAllResponses();
}
