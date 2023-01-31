package com.vam.timesheet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vam.timesheet.entity.Token;
import com.vam.timesheet.repository.TokenRepository;



@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token save(Token token) {
        return tokenRepository.save(token);
    }

    public void delete(String token) {
        tokenRepository.deleteByToken(token);
    }

    public List<Token> findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
