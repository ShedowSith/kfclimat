package ru.rahimyanov_aleks.KFClimat.pojo;

public enum TypeLogin {

    Client("Клиент"),
    Master("Мастер");

    private final String displayValue;
    private TypeLogin(String displayValue) {
        this.displayValue =displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }
}
