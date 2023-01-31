package com.vam.timesheet.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.timesheet.entity.Ticket;
import com.vam.timesheet.repository.TicketsRepository;


@Service
@Transactional
public class TicketsService {
 
    @Autowired
    private TicketsRepository repo;
     
    public List<Ticket> listAll() {
        return repo.findAll();
    }
     
    public void save(Ticket ticket) {
        repo.save(ticket);
    }
     
    public Ticket get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    public Ticket updateTicketByFields(int id, Map<String, Object> fields) {
        Optional<Ticket> existingTicket = repo.findById(id);

        if (existingTicket.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findRequiredField(Ticket.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingTicket.get(), value);
            });
            return repo.save(existingTicket.get());
        }
        return null;
    }
    
    
}