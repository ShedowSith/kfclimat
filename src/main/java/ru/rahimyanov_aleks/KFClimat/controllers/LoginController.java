package ru.rahimyanov_aleks.KFClimat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.domain.Master;
import ru.rahimyanov_aleks.KFClimat.pojo.FormLogin;
import ru.rahimyanov_aleks.KFClimat.pojo.TypeLogin;
import ru.rahimyanov_aleks.KFClimat.security.Session;
import ru.rahimyanov_aleks.KFClimat.security.TypeLoginForSession;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IClientService;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IMasterService;

@Controller
public class LoginController {
    private final Session session;
    private final IMasterService masterService;
    private final IClientService clientService;

    @Autowired
    public LoginController(Session session, IMasterService masterService, IClientService clientService) {
        this.session = session;
        this.masterService = masterService;
        this.clientService = clientService;
    }
    @GetMapping("/exit")
    public ModelAndView exit(){
        session.setTypeLogin(TypeLoginForSession.Guest);
        session.setId(null);
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView view = new ModelAndView();
        if (session.isTypeLogin() != TypeLoginForSession.Guest){
            view.setViewName("exit");
            return view;
        }

        FormLogin formLogin = new FormLogin();
        view.addObject("loginForm", formLogin);
        view.setViewName("login");
        return view;
    }

    @PostMapping("/login")
    public ModelAndView authorization(@ModelAttribute FormLogin formLogin){
        ModelAndView view = new ModelAndView();
        if (formLogin.getTypeLogin() == TypeLogin.Client){
            Client client = clientService.findClientByEmailAndPassword(formLogin.getEmail(), formLogin.getPassword());
            if (client != null) {
                session.setTypeLogin(TypeLoginForSession.Client);
                session.setId(client.getId());
            }
        } else if (formLogin.getTypeLogin() == TypeLogin.Master){
            Master master = masterService.findMasterByEmailAndPassword(formLogin.getEmail(), formLogin.getPassword());
            if (master != null) {
                session.setTypeLogin(TypeLoginForSession.Master);
                session.setId(master.getId());
            }
        }
        view.setViewName("redirect:/");
        return view;
    }

}
