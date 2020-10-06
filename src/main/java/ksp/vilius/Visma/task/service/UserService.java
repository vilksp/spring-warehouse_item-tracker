package ksp.vilius.Visma.task.service;

import ksp.vilius.Visma.task.dto.UserDto;
import ksp.vilius.Visma.task.exception.ProductException;
import ksp.vilius.Visma.task.model.User;
import ksp.vilius.Visma.task.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserDto userDto) {

        try {
            User user = new User();
            user.setUsername(user.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAccountCreationDate(LocalDate.now());

            userRepository.save(user);
        } catch (Exception e) {
            throw new ProductException("Your nickname is already in use");
        }

    }

}
