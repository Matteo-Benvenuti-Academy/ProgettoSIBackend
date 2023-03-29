package it.si.ProgettoSI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.si.ProgettoSI.dto.UserDto;
import it.si.ProgettoSI.models.Response;
import it.si.ProgettoSI.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService service; 

    @RequestMapping(
		  path = "/insert", 
		  method = RequestMethod.POST,
		  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		  produces = {
		    MediaType.APPLICATION_JSON_VALUE
		  })
    
    public Response insertHtml(UserDto userDto){ 
    	return this.insert(userDto);
    }
    
    @RequestMapping(
  		  path = "/insert", 
  		  method = RequestMethod.POST,
  		  consumes = MediaType.APPLICATION_JSON_VALUE, 
  		  produces = {
  		    MediaType.APPLICATION_JSON_VALUE
  		  })
    public Response insertJson(@RequestBody UserDto userDto){ 
    	return this.insert(userDto);
    }

    @GetMapping("/find")
    public Response findAll(){
        List<UserDto> users = service.findAll();
    	
        if (users == null || users.isEmpty())
        	return new Response("Bad Request",null);
    	
        return new Response("Ok",users);
    }
    
    @GetMapping("/find/{unique}")
    public Response findByUnique(@PathVariable String unique){
    	UserDto user = service.findByUnique(unique);
    	
    	if(user == null)
    		return new Response("User not found",null);
    	
    	return new Response("Ok",user);
    }
    
    private Response insert(UserDto userDto) {
    	if( userDto.getName() == null || userDto.getSurname() == null || userDto.getDate() == null) 
      		return new Response("Bad Request",null);
      	
      	UserDto user = service.insert(userDto);
      	
      	if (user == null) {
      		return new Response("Insert Failed",null);
      	}
      	
      	return new Response("Insert Failed",user);
    }
}
