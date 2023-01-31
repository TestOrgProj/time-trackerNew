package com.vam.timesheet.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vam.timesheet.entity.Timesheet;
@Repository
//@EnableJpaRepositories(basePackages ={ "package com.vam.timesheet.entity","package com.vam.timesheet.repository"})
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

	List<Timesheet> findAll();


	//@Query(value ="SELECT * FROM Timesheet  WHERE log_date = :query", nativeQuery = true)
	
    List<Timesheet> findByLogDate(Date query);
    List<Timesheet> findByLogDateBetween(Date date1,Date date2);
    List<Timesheet> findByLogDateBefore(Date Date);

//	@Query("select * from Timesheet cp join Project a on a.id = cp.id where name = :query")
//    @Query("SELECT * FROM Timesheet t JOIN Project a  WHERE a.name =  :projectName")
    List<Timesheet>findByTicket_Project_Name(String projectName);
    
    


}