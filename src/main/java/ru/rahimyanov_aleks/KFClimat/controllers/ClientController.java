package ru.rahimyanov_aleks.KFClimat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.rahimyanov_aleks.KFClimat.domain.*;
import ru.rahimyanov_aleks.KFClimat.security.Session;
import ru.rahimyanov_aleks.KFClimat.services.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ClientController {

    private final Session session;
    private final ClientService clientService;
    private final TypeService typeService;
    private final PowerService powerService;
    private final ApplicationService applicationService;
    private final ResponseService responseService;
    private final StateService stateService;

    @Autowired
    public ClientController(Session session, ClientService clientService, TypeService typeService, PowerService powerService, ApplicationService applicationService, ResponseService responseService, StateService stateService) {
        this.session = session;
        this.clientService = clientService;
        this.typeService = typeService;
        this.powerService = powerService;
        this.applicationService = applicationService;
        this.responseService = responseService;
        this.stateService = stateService;
    }

    @GetMapping("/client/application")
    public ModelAndView applicationPage(){
        ModelAndView view = new ModelAndView();
        Application application = new Application();
        Client client = clientService.getClient(session.getId());

        List<Type> types = typeService.getAllTypes();
        List<Power> powers = powerService.getAllPowers();
        view.addObject("name",String.format(("%s %s %s"), client.getSurname(), client.getName(), client.getPatronymic()));
        view.addObject("isTypeUser", "client");
        view.addObject("app", application);
        view.addObject("powers", powers);
        view.addObject("types", types);
        view.setViewName("add_application");
        return view;
    }

    @PostMapping("/client/application")
    public ModelAndView createApplication(@ModelAttribute Application application){
        ModelAndView view = new ModelAndView();

        Client client = clientService.getClient(session.getId());
        Type type = typeService.getType(application.getType().getId());
        Power power = powerService.getPower(application.getPower().getId());
        State state = stateService.getStateSearch();
        application.setPower(power);
        application.setType(type);
        application.setClient(client);
        application.setState(state);
        applicationService.createApplication(application);

        view.setViewName("redirect:/client/applications");
        return view;
    }
    @GetMapping("/client/applications")
    public ModelAndView applicationsPage(){
        ModelAndView view = new ModelAndView();

        Client client = clientService.getClient(session.getId());
        view.addObject("isTypeUser", "client");
        view.addObject("name",String.format(("%s %s %s"), client.getSurname(), client.getName(), client.getPatronymic()));

        List<Application> applications = applicationService.getAllApplicationForClient(client);
        view.addObject("applications", applications);
        view.setViewName("applications");
        return view;
    }

    @GetMapping("/client/application/{id}")
    public ModelAndView applicationPage(@PathVariable Long id){
        ModelAndView view = new ModelAndView();
        Client client = clientService.getClient(session.getId());
        Application application = applicationService.getApplication(id);
        view.addObject("isTypeUser", "client");
        view.addObject("name",String.format(("%s %s %s"), client.getSurname(), client.getName(), client.getPatronymic()));
        view.addObject("app", application);
        Response response = responseService.findSelectedResponseApplication(id);
        if (response != null){
            view.addObject("response", response);
            view.setViewName("application_selected_master");
        }else {
            view.setViewName("application");
        }

        return view;
    }
    @GetMapping("/client/application/{id}/responses")
    public ModelAndView applicationResponses(@PathVariable Long id){
        ModelAndView view = new ModelAndView();
        Client client = clientService.getClient(session.getId());
        Application application = applicationService.getApplication(id);
        Collection<Response> responses = application.getResponses();
        view.addObject("isTypeUser", "client");
        view.addObject("name",String.format(("%s %s %s"), client.getSurname(), client.getName(), client.getPatronymic()));
        view.addObject("responses", responses);
        view.addObject("id_app", id);
        view.setViewName("app_responses");
        return view;
    }

    @PostMapping("/client/application/{id}/response")
    public ModelAndView selectedResponse(@PathVariable Long id, @RequestParam("responseId") Long idRes){
        ModelAndView view = new ModelAndView();
        responseService.updateSelectedResponse(idRes);
        State state = stateService.getStatePerformance();
        applicationService.updateStateApplication(id, state);
        view.setViewName(String.format("redirect:/client/application/%s", id));
        return view;
    }
}
