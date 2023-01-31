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

import com.vam.timesheet.entity.Ticket;
import com.vam.timesheet.service.TicketsService;

@RestController
public class TicketController {

	@Autowired
	private TicketsService service;

	/**
	 * This method returns all the active tickets in the system.
	 * 
	 * @return
	 */
	@PostMapping("/listtickets")
	public List<Ticket> list() {
		return service.listAll();
	}

	/**
	 * This method returns the specific ticket by id in the system.
	 * 
	 * @return
	 */

	@PostMapping("/ticket/{id}")
	public ResponseEntity<Ticket> get(@PathVariable Integer id) {
		try {
			Ticket ticket = service.get(id);
			return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method used to create ticket in the system.
	 * 
	 * @return
	 */

	@PostMapping("/ticket")
	public ResponseEntity<Ticket> add(@RequestBody Ticket ticket) {
		service.save(ticket);
		return ResponseEntity.ok(ticket);
	}

	/**
	 * This method used to post some changes at particular id .
	 * 
	 * @return
	 */
	@PatchMapping("/ticket/{id}")
	public Ticket updateTicketFields(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return service.updateTicketByFields(id, fields);
	}

	/**
	 * This method delete the given active project in the system.
	 * 
	 * @return
	 */
	@DeleteMapping("/ticket/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
//        System.out.println("deleted");
		return "deleted successfully";

	}
}