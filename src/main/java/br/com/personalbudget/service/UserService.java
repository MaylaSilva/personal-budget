package br.com.personalbudget.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalbudget.model.entity.User;
import br.com.personalbudget.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findUserById(UUID id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado."
            ));
    }

}
