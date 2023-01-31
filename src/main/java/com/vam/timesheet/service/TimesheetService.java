package com.vam.timesheet.service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.timesheet.entity.Project;
import com.vam.timesheet.entity.Timesheet;
import com.vam.timesheet.repository.TimesheetRepository;

@Service
@Transactional
public class TimesheetService {

	@Autowired
	private TimesheetRepository repo;

//    public static List<Timesheet> search(String query) {
//        List<Timesheet> timesheet = TimesheetRepository.search(query);
//        return timesheet;
//    }
	public List<Timesheet> listAll() {
		return repo.findAll();
	}

	public void save(Timesheet timesheet) {
		repo.save(timesheet);
	}

	public Timesheet get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Timesheet updateTimesheetByFields(int id, Map<String, Object> fields) {
		Optional<Timesheet> existingTimesheet = repo.findById(id);

		if (existingTimesheet.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findRequiredField(Timesheet.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingTimesheet.get(), value);
			});
			return repo.save(existingTimesheet.get());
		}
		return null;
	}

	public List<Timesheet> searchTimesheet(String date1,String date2) {
		List<Timesheet> timesheets = repo.findByLogDateBetween(Date.valueOf(date1),Date.valueOf(date2));
		return timesheets;
	}
	
	public List<Timesheet> searchTimesheet(String query) {
		List<Timesheet> timesheets = repo.findByLogDate(Date.valueOf(query));
		return timesheets;
	}
	
	public List<Timesheet> searchTimesheetbefore(String date) {
		List<Timesheet> timesheets = repo.findByLogDateBefore(Date.valueOf(date));
		return timesheets;
	}
	
	
	public List<Timesheet> searchProjects(String projectName) {
		List<Timesheet> timesheets = repo.findByTicket_Project_Name(String.valueOf(projectName));
		return timesheets;
	}
}