package ksp.vilius.Visma.task.service;

import ksp.vilius.Visma.task.exception.ProductException;
import ksp.vilius.Visma.task.model.User;
import ksp.vilius.Visma.task.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(User user) {

        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(newUser);
        } catch (Exception e) {
            throw new ProductException("Your nickname is already in use");
        }

    }



}
