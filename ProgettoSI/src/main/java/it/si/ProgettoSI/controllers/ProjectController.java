package it.si.ProgettoSI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.si.ProgettoSI.services.ProjectService;

@RestController 
@RequestMapping("main")
public class ProjectController {

    @Autowired 
    private ProjectService service; 

    @GetMapping("hello") 
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("reverse") 
    public String reverse(@RequestParam String string){
        if (string == null)
            return "Pass a parameter \"string\" to use the function";
        
        return service.reverse(string); 
    
    }

}
