package com.vam.timesheet.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vam.timesheet.entity.EndUser;
import com.vam.timesheet.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * This method returns all the active projects in the system.
	 * 
	 * @return
	 */
	
	@PostMapping("/listusers")
	public List<EndUser> listuser() {
		return service.listuser();
	}
	
	
	/**
	 * This method returns the specific project by id in the system.
	 * 
	 * @return
	 */

	@PostMapping("/user/{id}")
	public ResponseEntity<EndUser> get(@PathVariable Integer id) {
		try {
			EndUser user = service.get(id);
//			service.save(project);
			return new ResponseEntity<EndUser>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<EndUser>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method used to create  project in the system.
	 * 
	 * @return
	 */
	@PostMapping("/user")
	public ResponseEntity<EndUser> add(@RequestBody EndUser user) {
        
		service.save(user);
		return ResponseEntity.ok(user);
	}

	/**
	 * This method used to post some changes at particular id .
	 * 
	 * @return
	 */
//    @PatchMapping("/user/{id}")
//    public ResponseEntity<?> update(@RequestBody User project, @PathVariable Integer id) {
//        try {
//        	User user1 = service.get(id);
//            
//            service.save(user1);
////            return new ResponseEntity<>(HttpStatus.OK);
//             return ResponseEntity.ok(project);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }      
//    }
//	@PutMapping("/{id}")
//    public User updateProduct(@PathVariable int id, @RequestBody User productRequest) {
//       return service.updateProduct(id, productRequest);
//    }
	 @PatchMapping("/{id}")
	    public EndUser updateUserFields(@PathVariable int id,@RequestBody Map<String, Object> fields){
	        return service.updateUserByFields(id,fields);
	    }
	
	
	
	
	
	
	

    /**
	 * This method delete the given active project in the system.
	 * 
	 * @return
	 */
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "deleted successfully";
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> userlogin(@RequestBody EndUser Data) {
    	EndUser Response = service.getemployeeById(Data.getEmailId());
    		if(Response.getPassword().equals(Data.getPassword())) {

    		return ResponseEntity.ok(Response);
    	}
    		return ResponseEntity.ok("please enter correct details");
    		
    }     

}