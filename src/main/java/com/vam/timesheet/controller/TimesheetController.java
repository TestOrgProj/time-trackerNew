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

import com.vam.timesheet.entity.Timesheet;
import com.vam.timesheet.service.TimesheetService;


@RestController
public class TimesheetController {

	@Autowired
	private TimesheetService service;

	/**
	 * This method returns all the active projects in the system.
	 * 
	 * @return
	 */
	@PostMapping("/listtimesheets")
	public List<Timesheet> list() {
		return service.listAll();
	}

	/**
	 * This method returns the specific timesheet by id in the system.
	 * 
	 * @return
	 */
	@PostMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> get(@PathVariable Integer id) {
		try {
			Timesheet timesheet = service.get(id);
			service.save(timesheet);
			return new ResponseEntity<Timesheet>(timesheet, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Timesheet>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method used to create timesheet in the system.
	 * 
	 * @return
	 */
	@PostMapping("/timesheet")
	public ResponseEntity<Timesheet> add(@RequestBody Timesheet timesheet) {
		service.save(timesheet);
		return ResponseEntity.ok(timesheet);
	}

	/**
	 * This method used to modify changes at particular timesheet .
	 * 
	 * @return
	 */
	@PatchMapping("/timesheet/{id}")
	public Timesheet updateTimesheetFields(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return service.updateTimesheetByFields(id, fields);
	}

	/**
	 * This method delete the given active project in the system.
	 * 
	 * @return
	 */
	@DeleteMapping("/timesheet/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
//        System.out.println("deleted");
		return "deleted successfully";

	}
	
	/**
	 * This method search the given active project based on a Particular Date in the system.
	 * 
	 * @return
	 */

	@PostMapping("/timesheet/search")
	
	public ResponseEntity<List<Timesheet>> searchTimesheet(@RequestBody Map<String, String> query) {
		System.out.println("controller %s" + query);
//		Log.info("controller {}",query);
		return ResponseEntity.ok(service.searchTimesheet(query.get("logDate")));
}
	/**
	 * This method search the given active project based on a given Date range in the system.
	 * 
	 * @return
	 */
	
	@PostMapping("/timesheet/search/between")
	
	public ResponseEntity<List<Timesheet>> searchTimesheet1(@RequestBody Map<String, String> query) {
		System.out.println("controller %s" + query);
//		Log.info("controller {}",query);
		return ResponseEntity.ok(service.searchTimesheet(query.get("startDate"),query.get("endDate")));
}
	 
	/**
	 * This method gives the  search result of the active projects before the given date in the system.
	 * 
	 * @return
	 */
	
	
	
	
@PostMapping("/timesheet/search/before")
	
	public ResponseEntity<List<Timesheet>> searchTimesheetBefore(@RequestBody Map<String, String> query) {
		System.out.println("controller %s" + query);
//		Log.info("controller {}",query);
		return ResponseEntity.ok(service.searchTimesheetbefore(query.get("logDate")));
}



@PostMapping("/timesheet/search/name")

public ResponseEntity<List<Timesheet>> searchProject(@RequestBody Map<String, String> query) {
	System.out.println("controller %s" + query);
//	Log.info("controller {}",query);
	return ResponseEntity.ok(service.searchProjects(query.get("projectName")));
}
	
	
	


	
	
	
	
	
//	@GetMapping("/search")
//    public ResponseEntity<List<Timesheet>> searchProducts(@RequestParam("query") String query){
//        return ResponseEntity.ok(TimesheetService.search(query));
//    }
}