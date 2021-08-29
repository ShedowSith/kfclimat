package ru.rahimyanov_aleks.KFClimat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IClientService;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IMasterService;

@Controller
public class RegistrationController {
    private final IMasterService masterService;
    private final IClientService clientService;

    @Autowired
    public RegistrationController(IMasterService masterService, IClientService clientService) {
        this.masterService = masterService;
        this.clientService = clientService;
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(){
        ModelAndView view = new ModelAndView();
        Client client = new Client();
        Master master = new Master();
        view.addObject("client", client);
        view.addObject("master", master);
        view.setViewName("registration");
        return view;
    }

    @PostMapping("/registration/client")
    public ModelAndView registrationClient(@ModelAttribute Client client){
        Client result = clientService.createClient(client);
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }
    @PostMapping("/registration/master")
    public ModelAndView registrationMaster(@ModelAttribute Master master){
        Master result = masterService.createMaster(master);
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }
}
