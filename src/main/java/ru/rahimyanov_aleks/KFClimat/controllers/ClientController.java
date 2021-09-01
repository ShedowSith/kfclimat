package ru.rahimyanov_aleks.KFClimat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.rahimyanov_aleks.KFClimat.domain.Application;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.domain.Power;
import ru.rahimyanov_aleks.KFClimat.domain.Type;
import ru.rahimyanov_aleks.KFClimat.security.Session;
import ru.rahimyanov_aleks.KFClimat.services.ApplicationService;
import ru.rahimyanov_aleks.KFClimat.services.ClientService;
import ru.rahimyanov_aleks.KFClimat.services.PowerService;
import ru.rahimyanov_aleks.KFClimat.services.TypeService;

import java.util.List;

@RestController
public class ClientController {

    private final Session session;
    private final ClientService clientService;
    private final TypeService typeService;
    private final PowerService powerService;
    private final ApplicationService applicationService;

    @Autowired
    public ClientController(Session session, ClientService clientService, TypeService typeService, PowerService powerService, ApplicationService applicationService) {
        this.session = session;
        this.clientService = clientService;
        this.typeService = typeService;
        this.powerService = powerService;
        this.applicationService = applicationService;
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
        view.addObject("application", application);
        view.addObject("powers", powers);
        view.addObject("types", types);
        view.setViewName("application");
        return view;
    }

    @PostMapping("/client/application")
    public ModelAndView createApplication(@ModelAttribute Application application){
        ModelAndView view = new ModelAndView();

        Client client = clientService.getClient(session.getId());
        Type type = typeService.getType(application.getType().getId());
        Power power = powerService.getPower(application.getPower().getId());
        application.setPower(power);
        application.setType(type);
        application.setClient(client);
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
}
