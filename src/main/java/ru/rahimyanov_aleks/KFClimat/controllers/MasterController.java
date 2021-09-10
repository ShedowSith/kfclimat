package ru.rahimyanov_aleks.KFClimat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.domain.Response;
import ru.rahimyanov_aleks.KFClimat.security.Session;
import ru.rahimyanov_aleks.KFClimat.services.ApplicationService;
import ru.rahimyanov_aleks.KFClimat.services.MasterService;
import ru.rahimyanov_aleks.KFClimat.services.ResponseService;

import java.util.Date;
import java.util.List;

@RestController
public class MasterController {

    private final Session session;
    private final MasterService masterService;
    private final ApplicationService applicationService;
    private final ResponseService responseService;

    @Autowired
    public MasterController(Session session, MasterService masterService, ApplicationService applicationService, ResponseService responseService) {
        this.session = session;
        this.masterService = masterService;
        this.applicationService = applicationService;
        this.responseService = responseService;
    }

    @GetMapping("/master/applications")
    public ModelAndView pageApplication(){
        ModelAndView view = new ModelAndView();
        Master master = masterService.getMaster(session.getId());
        view.addObject("name",String.format(("%s %s %s"), master.getSurname(), master.getName(), master.getPatronymic()));
        view.addObject("isTypeUser", "master");
        List<Application> applications = applicationService.getAllAppNotResponseMaster(session.getId());

        view.addObject("applications", applications);

        view.setViewName("applications");
        return view;
    }

    @GetMapping("/master/application/{id}")
    public ModelAndView applicationPageById(@PathVariable Long id){
        Application application = applicationService.getApplication(id);
        ModelAndView view = new ModelAndView();

        Master master = masterService.getMaster(session.getId());
        view.addObject("name",String.format(("%s %s %s"), master.getSurname(), master.getName(), master.getPatronymic()));
        view.addObject("isTypeUser", "master");

        view.addObject("app", application);
        view.setViewName("application");
        return view;
    }

    @GetMapping("/master/application/{id}/response")
    public ModelAndView pageResponse(@PathVariable Long id){
        ModelAndView view = new ModelAndView();
        Master master = masterService.getMaster(session.getId());
        view.addObject("name",String.format(("%s %s %s"), master.getSurname(), master.getName(), master.getPatronymic()));
        view.addObject("isTypeUser", "master");
        view.addObject("id_app", id);
        Response response = new Response();
        response.setDate(new Date());
        view.addObject("response", response);
        view.setViewName("response");
        return view;
    }

    @PostMapping("/master/application/{id}/response")
    public ModelAndView response(@PathVariable Long id, @ModelAttribute Response response){
        Master master = masterService.getMaster(session.getId());
        if(applicationService.getApplicationResponseMaster(id, master) == null){
            response.setApplication(applicationService.getApplication(id));
            response.setMaster(master);
            responseService.createResponse(response);
        }

        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/master/responses");
        return view;
    }

    @GetMapping("/master/responses")
    public ModelAndView pageResponse(){
        ModelAndView view =new ModelAndView();
        Master master = masterService.getMaster(session.getId());
        view.addObject("name",String.format(("%s %s %s"), master.getSurname(), master.getName(), master.getPatronymic()));
        view.addObject("isTypeUser", "master");
        List<Response> responses = responseService.getAllResponsesMasterId(master.getId());
        view.addObject("responses", responses);
        view.setViewName("responses");
        return view;
    }
}
