package it.si.ProgettoSI.services;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {  //serve alla computazione, dove troviamo logica di business dell'app, dunque la rende operativa
    
    public String reverse(String string){
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

}
