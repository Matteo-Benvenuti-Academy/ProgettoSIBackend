package it.si.ProgettoSI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.si.ProgettoSI.dto.UserDto;
import it.si.ProgettoSI.models.User;
import it.si.ProgettoSI.repository.UserRepository;

@Service
public class UserService { 
	
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private ModelMapper mapper;


    public UserDto insert(UserDto userDto) { 
        User user = mapper.map(userDto,User.class); 
        
        String unique = UUID.randomUUID().toString();

        User nuovoUser = repository.save(unique,user);

        if( nuovoUser == null)  
            return null;

        return mapper.map(nuovoUser,UserDto.class);
    }
    
    
    public UserDto findByUnique(String unique){
        User user = repository.findByUnique(unique);
        if(user == null)  
            return null;

    return mapper.map(user,UserDto.class); 
    }


	public List<UserDto> findAll() {
		List<User> users = repository.findAll();
		
		List<UserDto> usersDto = new ArrayList<>();
		for (User user : users) {
			usersDto.add(mapper.map(user, UserDto.class));
		}		
		return usersDto;
	}
}
