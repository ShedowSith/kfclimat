package ru.rahimyanov_aleks.KFClimat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.security.Session;
import ru.rahimyanov_aleks.KFClimat.security.TypeLoginForSession;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IClientService;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IMasterService;

@RestController
public class MainController {

    private final Session session;
    private final IMasterService masterService;
    private final IClientService clientService;

    @Autowired
    public MainController(Session session, IMasterService masterService, IClientService clientService) {
        this.session = session;
        this.masterService = masterService;
        this.clientService = clientService;
    }

    @GetMapping({"/","/index.html", "/index"})
    public ModelAndView main(){
        ModelAndView view = new ModelAndView();
        if (session.isTypeLogin()== TypeLoginForSession.Client){
            Client client = clientService.getClient(session.getId());
            view.addObject("name",String.format(("%s %s %s"), client.getSurname(), client.getName(), client.getPatronymic()));
            view.setViewName("client_panel");
        }else if (session.isTypeLogin()== TypeLoginForSession.Master){
            Master master = masterService.getMaster(session.getId());
            view.addObject("name",String.format(("%s %s %s"), master.getSurname(), master.getName(), master.getPatronymic()));
            view.setViewName("master_panel");
        } else {
            view.setViewName("index");
        }

        return view;
    }
}
