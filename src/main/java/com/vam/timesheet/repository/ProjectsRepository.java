package com.vam.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vam.timesheet.entity.Project;



public interface ProjectsRepository extends JpaRepository<Project, Integer> {

	List<Project> findAll();

	List<Project> findByname(String query);
 
}