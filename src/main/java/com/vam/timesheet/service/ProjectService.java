package com.vam.timesheet.service;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.timesheet.entity.Project;
import com.vam.timesheet.repository.ProjectsRepository;


@Service
@Transactional
public class ProjectService {

   @Autowired
   private ProjectsRepository repo;
    
   public List<Project> listprojects() {
	  
       return repo.findAll();
   }
    
   public void save(Project project) {
       repo.save(project);
   }
    
   public Project get(Integer id) {
       return repo.findById(id).get();
   }
    
   public void delete(Integer id) {
       repo.deleteById(id);
   }
   
   public Project updateProjectByFields(int id, Map<String, Object> fields) {
       Optional<Project> existingTicket = repo.findById(id);

       if (existingTicket.isPresent()) {
           fields.forEach((key, value) -> {
               Field field = ReflectionUtils.findRequiredField(Project.class, key);
               field.setAccessible(true);
               ReflectionUtils.setField(field, existingTicket.get(), value);
           });
           return repo.save(existingTicket.get());
       }
       return null;
   }


public List<Project> searchProjects(String query) {
	List<Project> timesheets = repo.findByname(String.valueOf(query));
	return timesheets;
}
   
   
   
   
   
   
   
   
}