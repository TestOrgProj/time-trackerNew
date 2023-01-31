package com.vam.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vam.timesheet.entity.Token;



public interface TokenRepository extends JpaRepository<Token, String> {
    void deleteByToken(String token);
    List<Token> findByToken(String token);
}

