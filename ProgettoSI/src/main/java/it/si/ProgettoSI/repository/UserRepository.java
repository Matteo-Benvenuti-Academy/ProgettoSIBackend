package it.si.ProgettoSI.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import it.si.ProgettoSI.models.User;

@Repository 
public class UserRepository {
    
    private HashMap<String,User> database = new HashMap<String,User>(); 

    public User save(String unique , User user){
        database.put(unique, user);  
        System.out.println(unique);
        return database.get(unique); 
    }

    public User findByUnique(String unique) {
        return database.get(unique); 
        
    }

	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		
		for(String key : database.keySet()){
			users.add(database.get(key));
	   }
		
		return users;
	}
}
