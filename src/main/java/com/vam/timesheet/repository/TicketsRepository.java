package com.vam.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vam.timesheet.entity.Ticket;



public interface TicketsRepository extends JpaRepository<Ticket, Integer> {

	List<Ticket> findAll();
 
}