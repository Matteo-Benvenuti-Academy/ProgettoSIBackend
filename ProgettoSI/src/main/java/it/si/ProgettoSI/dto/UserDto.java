package it.si.ProgettoSI.dto;

import java.time.LocalDate;

public class UserDto {
    

    private String name;
    private String surname;
    private LocalDate date;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }
}
