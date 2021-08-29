package ru.rahimyanov_aleks.KFClimat.security;

import org.springframework.stereotype.Component;

@Component
public class Session {
    private TypeLoginForSession typeLogin;
    private Long id;
    public Session() {
        this.typeLogin = TypeLoginForSession.Guest;
        this.id = null;
    }

    public void setTypeLogin(TypeLoginForSession typeLogin){
        this.typeLogin = typeLogin;
    }
    public TypeLoginForSession isTypeLogin(){
        return typeLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
