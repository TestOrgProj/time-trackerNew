package com.vam.timesheet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vam.timesheet.entity.EndUser;

public interface UserRepository extends JpaRepository<EndUser, Integer> {

	public List<EndUser> findAll();
	public EndUser findBypassword(String name);
	public Optional<EndUser> findByemailId(String emailId);
	public Optional<EndUser> findById(Long id);
	@Query(value ="select * from users u "
			+ "where u.email_id =:emailId", nativeQuery = true)
	EndUser findByemaIdAndPassw0rd(String emailId);
	

}
