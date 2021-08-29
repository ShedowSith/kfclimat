package ru.rahimyanov_aleks.KFClimat.pojo;

import lombok.Data;

@Data
public class FormLogin {
    private String email;
    private String password;
    private TypeLogin typeLogin;
}
