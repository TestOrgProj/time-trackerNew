package com.vam.timesheet.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.timesheet.entity.EndUser;
import com.vam.timesheet.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<EndUser> listuser() {

		return repo.findAll();
	}

	public void save(EndUser user) {
		repo.save(user);
	}

	public EndUser get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
    
	
	
	
//	 public User updateProduct(int id, User productRequest) {
//	        // get the product from DB by id
//	        // update with new value getting from request
//	        User existingProduct = repo.findById(id).get(); // DB
//	        
//	        existingProduct.setFirstName(productRequest.getFirstName());
//	        existingProduct.setLastName(productRequest.getLastName());
//	        existingProduct.setEmailId(productRequest.getEmailId());
//	        existingProduct.setPassword(productRequest.getPassword());
//	        existingProduct.setTotalExperience(productRequest.getTotalExperience());
//	        existingProduct.setVamExperience(productRequest.getVamExperience());
//	        existingProduct.setSkillSet(productRequest.getSkillSet());
//	        return repo.save(existingProduct);
//	    }
	 
	 public EndUser updateUserByFields(int id, Map<String, Object> fields) {
	        Optional<EndUser> existingUser = repo.findById(id);

	        if (existingUser.isPresent()) {
	            fields.forEach((key, value) -> {
	                Field field = ReflectionUtils.findRequiredField(EndUser.class, key);
	                field.setAccessible(true);
	                ReflectionUtils.setField(field, existingUser.get(), value);
	            });
	            return repo.save(existingUser.get());
	        }
	        return null;
	    }
	 public EndUser findByemailId(Long id) {
			// TODO Auto-generated method stub
			Optional<EndUser> employee = repo.findById(id);
		     return employee.get();
		     
		}
	 public EndUser getemployeeById(String emailId) {
			Optional<EndUser> employee = repo.findByemailId(emailId);
			return employee.get();
		}
	
			 
}
