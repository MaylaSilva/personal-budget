package br.com.personalbudget.service;

import org.springframework.stereotype.Service;

import br.com.personalbudget.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
