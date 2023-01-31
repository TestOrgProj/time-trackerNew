package com.vam.timesheet.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vam.timesheet.entity.Project;
import com.vam.timesheet.service.ProjectService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

	@Autowired
	private ProjectService service;

	/**
	 * This method returns all the active projects in the system.
	 * 
	 * @return
	 */
	@PostMapping("/listProjects")
	public List<Project> listProjects() {
		return service.listprojects();
	}

	/**
	 * This method returns the specific project by id in the system.
	 * 
	 * @return
	 */

	@PostMapping("/project/{id}")
	public ResponseEntity<Project> get(@PathVariable Integer id) {
		try {
			Project project = service.get(id);
//			service.save(project);
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method used to create project in the system.
	 * 
	 * @return
	 */
	@PostMapping("/project")
	public ResponseEntity<Project> add(@RequestBody Project project) {
		project.setStatus("Active");
		service.save(project);
		return ResponseEntity.ok(project);
	}

	/**
	 * This method used to post some changes at particular id .
	 * 
	 * @return
	 */
	@PatchMapping("/project/{id}")
	public Project updateProjectFields(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return service.updateProjectByFields(id, fields);
	}

	/**
	 * This method delete the given active project in the system.
	 * 
	 * @return
	 */
	@DeleteMapping("/project/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "deleted successfully";
	}
	
	
@PostMapping("/project/search")
	
	public ResponseEntity<List<Project>> searchProject(@RequestBody Map<String, String> query) {
		System.out.println("controller %s" + query);
//		Log.info("controller {}",query);
		return ResponseEntity.ok(service.searchProjects(query.get("projectName")));
}
	
	
	

}
